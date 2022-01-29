package calorii;

import static javax.swing.JOptionPane.showMessageDialog;

public class CaloriiInterfata extends javax.swing.JFrame {

    public CaloriiInterfata() {
        initComponents();
    }

    public static double calculareCalorii(char sex, int greutate, int inaltime, int varsta, double activitateFizica){
        double rezultat = 0, suma, varGreutate, varInaltime, varVarsta;

        if (sex == 'M'){
            varGreutate = 9.6 * greutate;
            varInaltime = 1.8 * inaltime;
            varVarsta = 4.7 * varsta;
            suma = 655 + varGreutate + varInaltime + varVarsta;
            rezultat = suma * activitateFizica;
        }else{
            varGreutate = 13.7 * greutate;
            varInaltime = 5 * inaltime;
            varVarsta = 6.8 * varsta;
            suma = 66 + varGreutate + varInaltime + varVarsta;
            rezultat = suma * activitateFizica;
        }
        return rezultat;
    }

    public void resetareDate(){
        greutateText.setText("");
        inaltimeText.setText("");
        varstaText.setText("");
        caloriiTotaleText.setText("");
        caloriiArse.setText("");
        grup_Butoane1.clearSelection();
        grup_Butoane2.clearSelection();
    }

    private void initComponents() {

        grup_Butoane1 = new javax.swing.ButtonGroup();
        grup_Butoane2 = new javax.swing.ButtonGroup();
        greutateText = new javax.swing.JTextField();
        inaltimeText = new javax.swing.JTextField();
        varstaText = new javax.swing.JTextField();
        butonFemeie = new javax.swing.JRadioButton();
        butonBarbat = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        activitateUsoara = new javax.swing.JRadioButton();
        activitateModerata = new javax.swing.JRadioButton();
        activitateIntensa = new javax.swing.JRadioButton();
        activitateRidicata = new javax.swing.JRadioButton();
        butonIesire = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        butonCalcul = new javax.swing.JButton();
        resetareParametrii = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        caloriiTotaleText = new javax.swing.JTextField();
        sedentar = new javax.swing.JRadioButton();
        caloriiArse = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        greutateText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                greutateTextIncorect(evt);
            }
        });

        inaltimeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                inaltimeTextIncorect(evt);
            }
        });

        varstaText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varstaTextIncorect(evt);
            }
        });

        grup_Butoane1.add(butonFemeie);
        butonFemeie.setText("Femeie");
        butonFemeie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonFemeieCalorii(evt);
            }
        });

        grup_Butoane1.add(butonBarbat);
        butonBarbat.setText("Barbat");

        jLabel1.setText("Greutate (KG)");

        jLabel2.setText("Inaltime (CM)");

        jLabel3.setText("Varsta");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Activitatea fizica (selectati una dintre cele 5 optiuni)");

        grup_Butoane2.add(activitateUsoara);
        activitateUsoara.setText("Activitate usoara (faceti activitate fizica o data sau de 3 ori pe saptamana)");
        activitateUsoara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activitateUsoaraPerformata(evt);
            }
        });

        grup_Butoane2.add(activitateModerata);
        activitateModerata.setText("Activitate moderata (faceti activitate fizica de 3 sau 5 ori pe saptamana)");

        grup_Butoane2.add(activitateIntensa);
        activitateIntensa.setText("Activitate intensa (faceti activitate fizica de 6 sau 7 ori pe saptamana)");

        grup_Butoane2.add(activitateRidicata);
        activitateRidicata.setText("Activitate extrem de ridicata (sportivii profesionisti)");

        butonIesire.setBackground(new java.awt.Color(153, 153, 255));
        butonIesire.setText("Iesire");
        butonIesire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonIesireApasat(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Introduceti urmatorii parametri");

        butonCalcul.setText("Calcul calorii");
        butonCalcul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonCalcActiuniPerf(evt);
            }
        });

        resetareParametrii.setText("Sterge parametrii");
        resetareParametrii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetareButonActivitatiFizice(evt);
            }
        });

        jLabel6.setText("Calorii pentru metabolismul bazal (BMR)");

        caloriiTotaleText.setEditable(false);

        grup_Butoane2.add(sedentar);
        sedentar.setText("Activitate sedentara (putina activitate fizica)");

        caloriiArse.setEditable(false);

        jLabel7.setText("Calorii de consumat pentru a pierde in greutate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(butonIesire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(sedentar)
                                                        .addComponent(activitateRidicata)
                                                        .addComponent(activitateIntensa)
                                                        .addComponent(activitateModerata)
                                                        .addComponent(jLabel4)
                                                        .addComponent(activitateUsoara)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(jLabel3))
                                                                                .addGap(29, 29, 29)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(inaltimeText)
                                                                                        .addComponent(greutateText)
                                                                                        .addComponent(varstaText, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(butonFemeie)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(butonBarbat)))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(butonCalcul)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(resetareParametrii))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel6)
                                                                                        .addComponent(jLabel7))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(caloriiTotaleText, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                                                                                        .addComponent(caloriiArse))))))
                                                .addGap(0, 6, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(butonCalcul)
                                        .addComponent(resetareParametrii))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(butonFemeie)
                                                        .addComponent(butonBarbat))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(greutateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(inaltimeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(varstaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sedentar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(activitateUsoara)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(activitateModerata)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(activitateIntensa))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(caloriiTotaleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(caloriiArse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel7))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(activitateRidicata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butonIesire, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        pack();
    }

    private void butonFemeieCalorii(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void activitateUsoaraPerformata(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void butonIesireApasat(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void butonCalcActiuniPerf(java.awt.event.ActionEvent evt) {
        if (butonFemeie.isSelected() || butonBarbat.isSelected() && !"".equals(greutateText.getText()) && !"".equals(inaltimeText.getText()) && !"".equals(varstaText.getText()) && activitateUsoara.isSelected() || activitateModerata.isSelected() || activitateIntensa.isSelected() || sedentar.isSelected()){
            char sex;
            double activitate = 0;
            if (butonFemeie.isSelected()) {
                sex = 'M';
            } else if (butonBarbat.isSelected()) {
                sex = 'M';
            } else {
                sex = '0';
            }
            if (activitateUsoara.isSelected()) {
                activitate = 1.375;
            } else if (activitateModerata.isSelected()) {
                activitate = 1.55;
            } else if (activitateIntensa.isSelected()) {
                activitate = 1.725;
            } else if (activitateRidicata.isSelected()) {
                activitate = 1.9;
            } else if (sedentar.isSelected()) {
                activitate = 1.2;
            }
            int caloriiTotale = (int) CaloriiInterfata.calculareCalorii(sex, Integer.parseInt(greutateText.getText()), Integer.parseInt(inaltimeText.getText()), Integer.parseInt(varstaText.getText()), activitate);
            int caloriiArse = (int) ((int) caloriiTotale*0.8);
            caloriiTotaleText.setText(String.valueOf(caloriiTotale));
            this.caloriiArse.setText(String.valueOf(caloriiArse));
        }else{
            showMessageDialog(null, "Nu au fost selectate toate câmpurile necesare pentru calcul.");
        }
    }

    private void resetareButonActivitatiFizice(java.awt.event.ActionEvent evt) {
        resetareDate();
    }

    private void greutateTextIncorect(java.awt.event.FocusEvent evt) {
        try{
            Integer.parseInt(greutateText.getText());
        }catch (NumberFormatException e){
            showMessageDialog(null, "Caracterele introduse nu au format numeric.");
            greutateText.requestFocus();
        }
    }

    private void inaltimeTextIncorect(java.awt.event.FocusEvent evt) {
        try{
            Integer.parseInt(inaltimeText.getText());
        }catch (NumberFormatException e){
            showMessageDialog(null, "Caracterele introduse nu au format numeric.");
            inaltimeText.requestFocus();
        }
    }

    private void varstaTextIncorect(java.awt.event.FocusEvent evt) {
        try{
            Integer.parseInt(varstaText.getText());
        }catch (NumberFormatException e){
            showMessageDialog(null, "Caracterele introduse nu au format numeric.");
            varstaText.requestFocus();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CaloriiInterfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CaloriiInterfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CaloriiInterfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CaloriiInterfata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CaloriiInterfata().setVisible(true);
            }
        });
    }

    private javax.swing.JRadioButton activitateRidicata;
    private javax.swing.JRadioButton activitateIntensa;
    private javax.swing.JRadioButton activitateUsoara;
    private javax.swing.JRadioButton activitateModerata;
    private javax.swing.JTextField inaltimeText;
    private javax.swing.JButton butonCalcul;
    private javax.swing.JRadioButton butonBarbat;
    private javax.swing.JRadioButton butonFemeie;
    private javax.swing.JButton butonIesire;
    private javax.swing.ButtonGroup grup_Butoane1;
    private javax.swing.ButtonGroup grup_Butoane2;
    private javax.swing.JTextField caloriiArse;
    private javax.swing.JTextField caloriiTotaleText;
    private javax.swing.JTextField varstaText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton resetareParametrii;
    private javax.swing.JTextField greutateText;
    private javax.swing.JRadioButton sedentar;
}