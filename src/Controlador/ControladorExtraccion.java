package Controlador;

import Modelo.*;
import Vista.*;
import Datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ControladorExtraccion {
    private ConsultasExtraccion modeloC = new ConsultasExtraccion();
    private ConsultasSangre modeloU = new ConsultasSangre();
    private ConsultasDonante modeloD = new ConsultasDonante();
    private final frmExtraccion vista;
    private final ExtraccionArreglo modelo;

    public ControladorExtraccion(frmExtraccion vista, ExtraccionArreglo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        this.vista.botonRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (vista.txtVolumen.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Complete todos los campos");
                } else {
                    try {

                        Float Volumen = Float.parseFloat(vista.txtVolumen.getText());

                        if (Volumen > 0 ) {
                            ExtraccionSangre c = new ExtraccionSangre(Volumen, 
                                    vista.comboGrupoSang.getSelectedItem().toString(),vista.comboRH.getSelectedItem().toString(),
                                    vista.comboDonantes.getSelectedItem().toString());
                            
                            modeloC.registrarExtraccion(c);
                            
                            int idSangre=modeloU.idSangre(vista.comboGrupoSang.getSelectedItem().toString() ,vista.comboRH.getSelectedItem().toString());
                            
                            modeloU.añadir(idSangre, Volumen);
                            
                            JOptionPane.showMessageDialog(null, "Extraccion Registrada");
                            actualizarTabla();
                            limpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "Digite datos validos");
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Solo se pueden digitar numeros en Volumen");

                    }

                }
            }
        }
        );
        this.vista.botonRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ControladorPrincipalUser controlador = new ControladorPrincipalUser(Repositorio.usuario_validado, new frmPrincipalUser());
                
                controlador.iniciar();
                vista.dispose();
            }
        }
        );
        this.vista.botonEliminar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int fila = vista.tblExtRepo.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar alguna Extraccion");
            } else {
                Object valorObj = vista.tblExtRepo.getValueAt(fila, 0);
                Object volumenRegresaObj = vista.tblExtRepo.getValueAt(fila, 2);

                String valor = valorObj.toString();
                String volumenRegresa = volumenRegresaObj.toString();

                String tipo = vista.tblExtRepo.getValueAt(fila, 3).toString();
                String rh = vista.tblExtRepo.getValueAt(fila, 4).toString();
                int idSangre = modeloU.idSangre(tipo, rh);
                try {
                    float volumenRegresaNum = Float.parseFloat(volumenRegresa);
                    int valorNum = Integer.parseInt(valor);
                    modeloU.disminuir(idSangre, volumenRegresaNum);
                    modeloC.eliminarExtraccion(valorNum);
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Extraccion eliminada");
                } catch (NumberFormatException ex) {
                    modeloC.eliminarExtraccion(Integer.parseInt(valor));
                    actualizarTabla();
                    JOptionPane.showMessageDialog(null, "Extraccion eliminada");
                }
            }
        }
    });
}
    public void actualizarTabla(){
        this.vista.tblExtRepo.setModel(ConsultasExtraccion.listar());
        this.vista.tblExtRepo.getTableHeader().setReorderingAllowed(false);//para que no se mueva
    }
    
    public void limpiarCampos(){
        this.vista.txtVolumen.setText(""); 
    }

    public void iniciar() {
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
        this.vista.tblExtRepo.setEditingColumn(2);
        DefaultComboBoxModel modeloCboEmpleados = new DefaultComboBoxModel();
        modeloD.comboDonante(modeloCboEmpleados);
        this.vista.comboDonantes.setModel(modeloCboEmpleados);
        actualizarTabla();
    }
}
