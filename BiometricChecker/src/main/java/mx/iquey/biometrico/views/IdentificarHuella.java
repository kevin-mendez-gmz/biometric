/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.iquey.biometrico.views;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.mx.iquey.to.AsistenciaTO;
import com.mx.iquey.to.TrabajadorTO;
import com.mx.utils.Constantes;

import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mx.iquey.biometrico.controller.BiometricoController;
import mx.iquey.biometrico.utils.ConstantsDesk;

/**
 *
 * @author jacuevas
 */
public class IdentificarHuella extends javax.swing.JFrame {

    private DPFPCapture Lector_ver = DPFPGlobal.getCaptureFactory().createCapture();
    private DPFPEnrollment Reclutador_ver = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    private DPFPVerification Verificador_ver = DPFPGlobal.getVerificationFactory().createVerification();
    private DPFPTemplate template_ver;
    public static String TEMPLATE_PROPERTY_ver = "template";
    public DPFPFeatureSet featuresinscripcion_ver;
    public DPFPFeatureSet featuresverificacion_ver;
    public BiometricoController controller = new BiometricoController();
    List<TrabajadorTO> trabajadoresList = null;

    /**
     * Creates new form CapturaHuella
     */
    public IdentificarHuella() {

        initComponents();
        getHuellas();
        jIntrucciones.setEnabled(false);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    protected void Iniciar() {
        Lector_ver.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });
        Lector_ver.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        Lector_ver.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
        Lector_ver.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        });
    }

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        lblImagenHuella_ide.setIcon(new ImageIcon(
                image.getScaledInstance(lblImagenHuella_ide.getWidth(),
                        lblImagenHuella_ide.getHeight(),
                        Image.SCALE_DEFAULT)));
        repaint();
        try {
            identificarHuella();
            stop();
            start();
            Reclutador_ver.clear();
        } catch (IOException ex) {
        }
    }

    public void EstadoHuellas() {
        Reclutador_ver.getFeaturesNeeded();

    }

    public void start() {
        Lector_ver.startCapture();
    }

    public void stop() {
        Lector_ver.stopCapture();
    }

    public DPFPTemplate getTemplate() {
        return template_ver;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template_ver;
        this.template_ver = template;
        firePropertyChange(TEMPLATE_PROPERTY_ver, old, template);
    }

    public void ProcesarCaptura(DPFPSample sample) {
        //Procesar la muestra de la huella y crear un conjunto de caracteristicas con el proposito de inscripcion
        featuresinscripcion_ver = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        //Procesar la muestra de la huella y crear un conjunto de caracteristicas con el proposito de verificacion
        featuresverificacion_ver = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        //Comprobar la calidad de la muestra de la huella y lo añadea su reclutador si es bueno
        if (featuresinscripcion_ver != null) {
            try {
                Reclutador_ver.addFeatures(featuresinscripcion_ver); //Agregar las caracteristicas de la huella a la plantilla

                //Dibuja la huella dactilar capturada
                Image image = CrearImagenHuella(sample);
                DibujarHuella(image);

            } catch (DPFPImageQualityException ex) {
                System.err.println("Error: " + ex.getMessage());;
            } finally {
                EstadoHuellas();
                //Comprueba si la plantilla se ha creado
                switch (Reclutador_ver.getTemplateStatus()) {
                    case TEMPLATE_STATUS_READY: // informe de exito y detiene la captura de huella digital
                        stop();
                        setTemplate(Reclutador_ver.getTemplate());
                        break;
                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
                        Reclutador_ver.clear();
                        stop();
                        EstadoHuellas();
                        setTemplate(null);
                        start();
                        break;
                }

            }
        }
    }

    public void identificarHuella() throws IOException {

        try {
            //TRAER TODAS LAS HUELLAS

            for (TrabajadorTO trabajador : trabajadoresList) {

                byte templateBuffer[] = trabajador.getHuella();

                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                setTemplate(referenceTemplate);
                DPFPVerificationResult result = Verificador_ver.verify(featuresverificacion_ver, getTemplate());
                if (result.isVerified()) {

                    SimpleDateFormat format = new SimpleDateFormat(Constantes.FORMATO_FECHA);
                    Date currentDate = new Date();
                    //VER SI EXISTE UN REGISTRO DE ESA FECHA
//                AsistenciaTO asistencia = ObtenerAsistencia
                    AsistenciaTO asistencia = controller.getAsistenciaByTrabajador(trabajador.getIdTrabajador());

                    if (asistencia.getIdAsistencia() == 0) {
                        asistencia = new AsistenciaTO();
                        asistencia.setTrabajador(trabajador);
                        asistencia.setFecha(format.format(currentDate));
                        asistencia.setHoraEntrada(String.valueOf(currentDate.getTime()));
                        //ENVIAR A INSERTAR
                        controller.insertAsistencia(asistencia);
                        jMsg.setText(("ENTRADA::::: Bienvenido (a) al trabajo " + trabajador.getNombre() + "  Que tengas un excelente dia.").toUpperCase());
                    } else if (asistencia.getHoraSalida() == null) {
                        //ACTUALIZAR LA FECHA SALIDA
                        asistencia.setHoraSalida(String.valueOf(currentDate.getTime()));
                        //ENVIAR A ACTUALIZAR
                        controller.updateAsistencia(asistencia);
                        jMsg.setText(("SALIDA :::::: Gracias por tu esfuerzo de hoy " + trabajador.getNombre() + ",  Que tengas buen resto del dia.").toUpperCase());

                    }
                    stop();
                    start();
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "No existe ningun registro que coincida con la huella", "Verificador de Huella", JOptionPane.ERROR_MESSAGE);
            setTemplate(null);
            stop();
            start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    ConstantsDesk.MSG_ERROR_CONEXION,
                    "ERROR DE CONEXION",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImagenHuella_ide = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jMsg = new javax.swing.JLabel();
        jBtnRegistro = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jIntrucciones = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblImagenHuella_ide.setBackground(new java.awt.Color(204, 255, 204));
        lblImagenHuella_ide.setBorder(new javax.swing.border.MatteBorder(null));
        lblImagenHuella_ide.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jMsg.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 15)); // NOI18N
        jMsg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jBtnRegistro.setBackground(new java.awt.Color(204, 255, 204));
        jBtnRegistro.setFont(new java.awt.Font("Meiryo", 0, 14)); // NOI18N
        jBtnRegistro.setText("Agregar Trabajador");
        jBtnRegistro.setOpaque(false);
        jBtnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistroActionPerformed(evt);
            }
        });

        jIntrucciones.setColumns(20);
        jIntrucciones.setRows(5);
        jIntrucciones.setText("INSTRUCCIONES:\n\nColoca sobre el lector de huella\ndigital tu dedo que se registro\npreviamente.\n\nUna vez que el dedo este sobre \nel lector mostrara un mensaje en\nel momento en en el que se\nregistre tu entrada y tu salida.\n\nFavor de esparar 5 segundos antes\nde volver a intentar colocar tu\ndedo en caso de que no se haya\nregistrado tu asistencia.");
        jIntrucciones.setBorder(null);
        jScrollPane2.setViewportView(jIntrucciones);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagenHuella_ide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBtnRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(757, 757, 757))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagenHuella_ide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        stop();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Iniciar();
        start();
        EstadoHuellas();
    }//GEN-LAST:event_formWindowOpened

    private void jBtnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistroActionPerformed
        stop();
        CapturaHuella capturaHuella = new CapturaHuella();
        capturaHuella.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBtnRegistroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IdentificarHuella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdentificarHuella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdentificarHuella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentificarHuella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdentificarHuella.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(IdentificarHuella.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(IdentificarHuella.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(IdentificarHuella.class
                    .getName()).log(Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdentificarHuella().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnRegistro;
    private javax.swing.JTextArea jIntrucciones;
    private javax.swing.JLabel jMsg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagenHuella_ide;
    // End of variables declaration//GEN-END:variables

    private void getHuellas() {

        try {
            trabajadoresList = controller.getTrabajadores();
        } catch (Exception ex) {
            Logger.getLogger(IdentificarHuella.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
