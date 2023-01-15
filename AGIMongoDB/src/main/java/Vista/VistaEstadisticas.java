/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author adrianmorenomonterde
 */
public class VistaEstadisticas extends javax.swing.JPanel {

    /**
     * Creates new form VistaEstadisticas
     */
    public VistaEstadisticas() {
        initComponents();
    }
    
    private String usuario1, usuario2, usuario3, usuario4, usuario5;
    
    public void setUsuariosConMasSeguidores(String usuario1, String usuario2, String usuario3, String usuario4, String usuario5)
    {
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
        this.usuario3 = usuario3;
        this.usuario4 = usuario4;
        this.usuario5 = usuario5; 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelColeccion = new javax.swing.JLabel();
        jComboBoxColecciones = new javax.swing.JComboBox<>();
        jLabelTweetsAlmacenados = new javax.swing.JLabel();
        jLabelNTweetsAlmacenados = new javax.swing.JLabel();
        jLabelPeriodoDeDescarga = new javax.swing.JLabel();
        jLabelUsuarioConMasSeguidores = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelCon = new javax.swing.JLabel();
        jLabelNFollowers = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelFechaMasReciente = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelFechaMenosReciente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelUsuarioConMasSeguidores1 = new javax.swing.JLabel();
        jLabelUsuarioConMasSeguidores2 = new javax.swing.JLabel();
        jLabelUsuarioConMasSeguidores3 = new javax.swing.JLabel();
        jLabelUsuarioConMasSeguidores4 = new javax.swing.JLabel();
        jLabelUsuarioConMasSeguidores5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelHashtagMasUtilizado1 = new javax.swing.JLabel();
        jLabelHashtagMasUtilizado2 = new javax.swing.JLabel();
        jLabelHashtagMasUtilizado3 = new javax.swing.JLabel();
        jLabelHashtagMasUtilizado4 = new javax.swing.JLabel();
        jLabelHashtagMasUtilizado5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelNumeroIdiomasDiferentes = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelIdiomaMasUtilizado1 = new javax.swing.JLabel();
        jLabelIdiomaMasUtilizado2 = new javax.swing.JLabel();
        jLabelIdiomaMasUtilizado3 = new javax.swing.JLabel();
        jLabelIdiomaMasUtilizado4 = new javax.swing.JLabel();
        jLabelIdiomaMasUtilizado5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabelNumeroRTs = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabelNUsuariosDiferentes = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabelUsuarioConMasTweets1 = new javax.swing.JLabel();
        jLabelUsuarioConMasTweets2 = new javax.swing.JLabel();
        jLabelUsuarioConMasTweets3 = new javax.swing.JLabel();
        jLabelUsuarioConMasTweets4 = new javax.swing.JLabel();
        jLabelUsuarioConMasTweets5 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButtonCambiarColeccionEstadisticas = new javax.swing.JButton();

        jLabelColeccion.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelColeccion.setText("Colección ");

        jComboBoxColecciones.setActionCommand("");

        jLabelTweetsAlmacenados.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelTweetsAlmacenados.setText("Número de tweets almacenados: ");

        jLabelNTweetsAlmacenados.setText("NTweets");

        jLabelPeriodoDeDescarga.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelPeriodoDeDescarga.setText("Periodo de descarga: Desde ");

        jLabelUsuarioConMasSeguidores.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabelUsuarioConMasSeguidores.setText("Usuario con más seguidores: ");

        jLabelUsername.setText("username");

        jLabelCon.setText("con");

        jLabelNFollowers.setText("followers");

        jLabel1.setText("seguidores");

        jLabelFechaMasReciente.setText("Fecha mas reciente");

        jLabel3.setText("hasta");

        jLabelFechaMenosReciente.setText("Fecha menos reciente");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("Usuarios con más menciones: ");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("1.-");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("2.-");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("3.-");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("4.-");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setText("5.-");

        jLabelUsuarioConMasSeguidores1.setText("UsuarioConMásMenciones1");

        jLabelUsuarioConMasSeguidores2.setText("UsuarioConMásMenciones2");

        jLabelUsuarioConMasSeguidores3.setText("UsuarioConMásMenciones3");

        jLabelUsuarioConMasSeguidores4.setText("UsuarioConMásMenciones4");

        jLabelUsuarioConMasSeguidores5.setText("UsuarioConMásMenciones5");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setText("#Hashtags más utilizados:");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel10.setText("1.-");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("2.-");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel12.setText("3.-");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel13.setText("4.-");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel14.setText("5.-");

        jLabelHashtagMasUtilizado1.setText("HashtagMásUtilizado1");

        jLabelHashtagMasUtilizado2.setText("HashtagMásUtilizado2");

        jLabelHashtagMasUtilizado3.setText("HashtagMásUtilizado3");

        jLabelHashtagMasUtilizado4.setText("HashtagMásUtilizado4");

        jLabelHashtagMasUtilizado5.setText("HashtagMásUtilizado5");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel15.setText("Número de idiomas diferentes: ");

        jLabelNumeroIdiomasDiferentes.setText("nIdiomasDiferentes");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel16.setText("Idiomas más frecuentes:");

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel17.setText("1.-");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel18.setText("2.-");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel19.setText("3.-");

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel20.setText("4.-");

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel21.setText("5.-");

        jLabelIdiomaMasUtilizado1.setText("IdiomaMásUtilizado1");

        jLabelIdiomaMasUtilizado2.setText("IdiomaMásUtilizado2");

        jLabelIdiomaMasUtilizado3.setText("IdiomaMásUtilizado3");

        jLabelIdiomaMasUtilizado4.setText("IdiomaMásUtilizado4");

        jLabelIdiomaMasUtilizado5.setText("IdiomaMásUtilizado5");

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel22.setText("Número de Retweets en la colección:");

        jLabelNumeroRTs.setText("numeroRTs");

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel23.setText("Número de usuarios diferentes en la colección:");

        jLabelNUsuariosDiferentes.setText("nUsuariosDiferentes");

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel24.setText("Usuarios con más tweets en la colección:");

        jLabel25.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel25.setText("1.-");

        jLabel26.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel26.setText("2.-");

        jLabel27.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel27.setText("3.-");

        jLabel28.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel28.setText("4.-");

        jLabel29.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel29.setText("5.-");

        jLabelUsuarioConMasTweets1.setText("UsuarioConMasTweets1");

        jLabelUsuarioConMasTweets2.setText("UsuarioConMasTweets2");

        jLabelUsuarioConMasTweets3.setText("UsuarioConMasTweets3");

        jLabelUsuarioConMasTweets4.setText("UsuarioConMasTweets4");

        jLabelUsuarioConMasTweets5.setText("UsuarioConMasTweets5");

        jLabel30.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("SECCIÓN DE ESTADÍSTICAS");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Statistics-Vector-PNG-File.png"))); // NOI18N
        jLabel31.setMaximumSize(new java.awt.Dimension(53, 16));
        jLabel31.setPreferredSize(new java.awt.Dimension(53, 16));

        jButtonCambiarColeccionEstadisticas.setText("Aceptar");
        jButtonCambiarColeccionEstadisticas.setActionCommand("cambiarColeccion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTweetsAlmacenados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNTweetsAlmacenados))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIdiomaMasUtilizado2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNumeroIdiomasDiferentes))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPeriodoDeDescarga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFechaMasReciente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelFechaMenosReciente))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelUsuarioConMasSeguidores3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelUsuarioConMasSeguidores4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelUsuarioConMasSeguidores1)
                                    .addComponent(jLabelUsuarioConMasSeguidores2)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIdiomaMasUtilizado3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIdiomaMasUtilizado4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIdiomaMasUtilizado5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelHashtagMasUtilizado1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelHashtagMasUtilizado2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelHashtagMasUtilizado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelHashtagMasUtilizado4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelHashtagMasUtilizado5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelUsuarioConMasSeguidores5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIdiomaMasUtilizado1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNumeroRTs))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabelUsuarioConMasSeguidores)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelUsername)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelCon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelNFollowers)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNUsuariosDiferentes)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelColeccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxColecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonCambiarColeccionEstadisticas))
                                    .addComponent(jLabel24)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelUsuarioConMasTweets1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelUsuarioConMasTweets2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelUsuarioConMasTweets3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelUsuarioConMasTweets4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelUsuarioConMasTweets5)))
                                .addGap(2, 2, 2))
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTweetsAlmacenados)
                    .addComponent(jLabelNTweetsAlmacenados)
                    .addComponent(jLabelColeccion)
                    .addComponent(jComboBoxColecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCambiarColeccionEstadisticas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeriodoDeDescarga)
                    .addComponent(jLabelFechaMasReciente)
                    .addComponent(jLabel3)
                    .addComponent(jLabelFechaMenosReciente))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuarioConMasSeguidores)
                    .addComponent(jLabelUsername)
                    .addComponent(jLabelCon)
                    .addComponent(jLabelNFollowers)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabelUsuarioConMasSeguidores1)
                    .addComponent(jLabel25)
                    .addComponent(jLabelUsuarioConMasTweets1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelUsuarioConMasSeguidores2)
                    .addComponent(jLabel26)
                    .addComponent(jLabelUsuarioConMasTweets2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelUsuarioConMasSeguidores3)
                    .addComponent(jLabel27)
                    .addComponent(jLabelUsuarioConMasTweets3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelUsuarioConMasSeguidores4)
                    .addComponent(jLabel28)
                    .addComponent(jLabelUsuarioConMasTweets4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelUsuarioConMasSeguidores5)
                    .addComponent(jLabel29)
                    .addComponent(jLabelUsuarioConMasTweets5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabelHashtagMasUtilizado1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabelHashtagMasUtilizado2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabelHashtagMasUtilizado3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabelHashtagMasUtilizado4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabelHashtagMasUtilizado5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabelNumeroIdiomasDiferentes))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabelIdiomaMasUtilizado1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabelIdiomaMasUtilizado2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabelIdiomaMasUtilizado3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabelIdiomaMasUtilizado4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabelIdiomaMasUtilizado5)))
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabelNumeroRTs))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabelNUsuariosDiferentes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonCambiarColeccionEstadisticas;
    public javax.swing.JComboBox<String> jComboBoxColecciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelColeccion;
    private javax.swing.JLabel jLabelCon;
    public javax.swing.JLabel jLabelFechaMasReciente;
    public javax.swing.JLabel jLabelFechaMenosReciente;
    public javax.swing.JLabel jLabelHashtagMasUtilizado1;
    public javax.swing.JLabel jLabelHashtagMasUtilizado2;
    public javax.swing.JLabel jLabelHashtagMasUtilizado3;
    public javax.swing.JLabel jLabelHashtagMasUtilizado4;
    public javax.swing.JLabel jLabelHashtagMasUtilizado5;
    public javax.swing.JLabel jLabelIdiomaMasUtilizado1;
    public javax.swing.JLabel jLabelIdiomaMasUtilizado2;
    public javax.swing.JLabel jLabelIdiomaMasUtilizado3;
    public javax.swing.JLabel jLabelIdiomaMasUtilizado4;
    public javax.swing.JLabel jLabelIdiomaMasUtilizado5;
    public javax.swing.JLabel jLabelNFollowers;
    public javax.swing.JLabel jLabelNTweetsAlmacenados;
    public javax.swing.JLabel jLabelNUsuariosDiferentes;
    public javax.swing.JLabel jLabelNumeroIdiomasDiferentes;
    public javax.swing.JLabel jLabelNumeroRTs;
    private javax.swing.JLabel jLabelPeriodoDeDescarga;
    private javax.swing.JLabel jLabelTweetsAlmacenados;
    public javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelUsuarioConMasSeguidores;
    public javax.swing.JLabel jLabelUsuarioConMasSeguidores1;
    public javax.swing.JLabel jLabelUsuarioConMasSeguidores2;
    public javax.swing.JLabel jLabelUsuarioConMasSeguidores3;
    public javax.swing.JLabel jLabelUsuarioConMasSeguidores4;
    public javax.swing.JLabel jLabelUsuarioConMasSeguidores5;
    public javax.swing.JLabel jLabelUsuarioConMasTweets1;
    public javax.swing.JLabel jLabelUsuarioConMasTweets2;
    public javax.swing.JLabel jLabelUsuarioConMasTweets3;
    public javax.swing.JLabel jLabelUsuarioConMasTweets4;
    public javax.swing.JLabel jLabelUsuarioConMasTweets5;
    // End of variables declaration//GEN-END:variables
}
