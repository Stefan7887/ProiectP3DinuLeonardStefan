package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainDialog extends JFrame {
    private JRadioButton activitateRidicata;
    private JRadioButton activitateIntensa;
    private JRadioButton activitateUsoara;
    private JRadioButton activitateModerata;
    private JTextField inaltimeText;
    private JButton butonCalcul;
    private JRadioButton butonBarbat;
    private JRadioButton butonFemeie;
    private JButton butonIesire;
    private ButtonGroup grup_Butoane1;
    private ButtonGroup grup_Butoane2;
    private JTextField caloriiArse;
    private JTextField caloriiTotaleText;
    private JTextField varstaText;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JButton resetareParametrii;
    private JTextField greutateText;
    private JRadioButton sedentar;

    public MainDialog() {
        this.initComponents();
    }

    public static double calculareCalorii(char sex, int greutate, int inaltime, int varsta, double activitateFizica) {
        double rezultat = 0.0D;
        double suma;
        double varGreutate;
        double varInaltime;
        double varVarsta;
        if (sex == 'M') {
            varGreutate = 9.6D * (double)greutate;
            varInaltime = 1.8D * (double)inaltime;
            varVarsta = 4.7D * (double)varsta;
            suma = 655.0D + varGreutate + varInaltime + varVarsta;
            rezultat = suma * activitateFizica;
        } else {
            varGreutate = 13.7D * (double)greutate;
            varInaltime = (double)(5 * inaltime);
            varVarsta = 6.8D * (double)varsta;
            suma = 66.0D + varGreutate + varInaltime + varVarsta;
            rezultat = suma * activitateFizica;
        }
        return rezultat;
    }

    public void resetareDate() {
        this.greutateText.setText("");
        this.inaltimeText.setText("");
        this.varstaText.setText("");
        this.caloriiTotaleText.setText("");
        this.caloriiArse.setText("");
        this.grup_Butoane1.clearSelection();
        this.grup_Butoane2.clearSelection();
    }

    private void initComponents() {
        this.grup_Butoane1 = new ButtonGroup();
        this.grup_Butoane2 = new ButtonGroup();
        this.greutateText = new JTextField();
        this.inaltimeText = new JTextField();
        this.varstaText = new JTextField();
        this.butonFemeie = new JRadioButton();
        this.butonBarbat = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.activitateUsoara = new JRadioButton();
        this.activitateModerata = new JRadioButton();
        this.activitateIntensa = new JRadioButton();
        this.activitateRidicata = new JRadioButton();
        this.butonIesire = new JButton();
        this.jLabel5 = new JLabel();
        this.butonCalcul = new JButton();
        this.resetareParametrii = new JButton();
        this.jLabel6 = new JLabel();
        this.caloriiTotaleText = new JTextField();
        this.sedentar = new JRadioButton();
        this.caloriiArse = new JTextField();
        this.jLabel7 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.greutateText.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                MainDialog.this.greutateTextIncorect(evt);
            }
        });
        this.inaltimeText.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                MainDialog.this.inaltimeTextIncorect(evt);
            }
        });
        this.varstaText.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                MainDialog.this.varstaTextIncorect(evt);
            }
        });
        this.grup_Butoane1.add(this.butonFemeie);
        this.butonFemeie.setText("Femeie");
        this.butonFemeie.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainDialog.this.butonFemeieCalorii(evt);
            }
        });
        this.grup_Butoane1.add(this.butonBarbat);
        this.butonBarbat.setText("Barbat");
        this.jLabel1.setText("Greutate (KG)");
        this.jLabel2.setText("Inaltime (CM)");
        this.jLabel3.setText("Varsta");
        this.jLabel4.setFont(new Font("Dialog", 1, 14));
        this.jLabel4.setText("Activitatea fizica (selectati una dintre cele 5 optiuni)");
        this.grup_Butoane2.add(this.activitateUsoara);
        this.activitateUsoara.setText("Activitate usoara (faceti activitate fizica o data sau de 3 ori pe saptamana)");
        this.activitateUsoara.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainDialog.this.activitateUsoaraPerformata(evt);
            }
        });
        this.grup_Butoane2.add(this.activitateModerata);
        this.activitateModerata.setText("Activitate moderata (faceti activitate fizica de 3 sau 5 ori pe saptamana)");
        this.grup_Butoane2.add(this.activitateIntensa);
        this.activitateIntensa.setText("Activitate intensa (faceti activitate fizica de 6 sau 7 ori pe saptamana)");
        this.grup_Butoane2.add(this.activitateRidicata);
        this.activitateRidicata.setText("Activitate extrem de ridicata (sportivii profesionisti)");
        this.butonIesire.setBackground(new Color(153, 153, 255));
        this.butonIesire.setText("Iesire");
        this.butonIesire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainDialog.this.butonIesireApasat(evt);
            }
        });
        this.jLabel5.setFont(new Font("Dialog", 1, 14));
        this.jLabel5.setText("Introduceti urmatorii parametri");
        this.butonCalcul.setText("Calcul calorii");
        this.butonCalcul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainDialog.this.butonCalcActiuniPerf(evt);
            }
        });
        this.resetareParametrii.setText("Sterge parametrii");
        this.resetareParametrii.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                MainDialog.this.resetareButonActivitatiFizice(evt);
            }
        });
        this.jLabel6.setText("Calorii pentru metabolismul bazal (BMR)");
        this.caloriiTotaleText.setEditable(false);
        this.grup_Butoane2.add(this.sedentar);
        this.sedentar.setText("Activitate sedentara (putina activitate fizica)");
        this.caloriiArse.setEditable(false);
        this.jLabel7.setText("Calorii de consumat pentru a pierde in greutate");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.butonIesire, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.sedentar).addComponent(this.activitateRidicata).addComponent(this.activitateIntensa).addComponent(this.activitateModerata).addComponent(this.jLabel4).addComponent(this.activitateUsoara).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel5).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3)).addGap(29, 29, 29).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.inaltimeText).addComponent(this.greutateText).addComponent(this.varstaText, -2, 67, -2))).addGroup(layout.createSequentialGroup().addComponent(this.butonFemeie).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.butonBarbat))).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.butonCalcul).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.resetareParametrii)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.jLabel7)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.caloriiTotaleText, -1, 64, 32767).addComponent(this.caloriiArse)))))).addGap(0, 6, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.butonCalcul).addComponent(this.resetareParametrii)).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.butonFemeie).addComponent(this.butonBarbat)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.greutateText, -2, -1, -2).addComponent(this.jLabel1)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.inaltimeText, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.varstaText, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.sedentar).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.activitateUsoara).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.activitateModerata).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.activitateIntensa)).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.caloriiTotaleText, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.caloriiArse, -2, -1, -2).addComponent(this.jLabel7)))).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.activitateRidicata).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.butonIesire, -2, 57, -2).addContainerGap()));
        this.pack();
    }

    private void butonFemeieCalorii(ActionEvent evt) {
    }

    private void activitateUsoaraPerformata(ActionEvent evt) {
    }

    private void butonIesireApasat(ActionEvent evt) {
        System.exit(0);
    }

    private void butonCalcActiuniPerf(ActionEvent evt) {
        if (!this.butonFemeie.isSelected() && (!this.butonBarbat.isSelected() || "".equals(this.greutateText.getText()) || "".equals(this.inaltimeText.getText()) || "".equals(this.varstaText.getText()) || !this.activitateUsoara.isSelected()) && !this.activitateModerata.isSelected() && !this.activitateIntensa.isSelected() && !this.sedentar.isSelected()) {
            JOptionPane.showMessageDialog((Component)null, "Nu au fost selectate toate câmpurile necesare pentru calcul.");
        } else {
            double activitate = 0.0D;
            char sex;
            if (this.butonFemeie.isSelected()) {
                sex = 'M';
            } else if (this.butonBarbat.isSelected()) {
                sex = 'M';
            } else {
                sex = '0';
            }

            if (this.activitateUsoara.isSelected()) {
                activitate = 1.375D;
            } else if (this.activitateModerata.isSelected()) {
                activitate = 1.55D;
            } else if (this.activitateIntensa.isSelected()) {
                activitate = 1.725D;
            } else if (this.activitateRidicata.isSelected()) {
                activitate = 1.9D;
            } else if (this.sedentar.isSelected()) {
                activitate = 1.2D;
            }

            int caloriiTotale = (int)calculareCalorii(sex, Integer.parseInt(this.greutateText.getText()), Integer.parseInt(this.inaltimeText.getText()), Integer.parseInt(this.varstaText.getText()), activitate);
            int caloriiArse = (int)((double)caloriiTotale * 0.8D);
            this.caloriiTotaleText.setText(String.valueOf(caloriiTotale));
            this.caloriiArse.setText(String.valueOf(caloriiArse));
        }

    }

    private void resetareButonActivitatiFizice(ActionEvent evt) {
        this.resetareDate();
    }

    private void greutateTextIncorect(FocusEvent evt) {
        try {
            Integer.parseInt(this.greutateText.getText());
        } catch (NumberFormatException var3) {
            JOptionPane.showMessageDialog((Component)null, "Caracterele introduse nu au format numeric.");
            this.greutateText.requestFocus();
        }

    }

    private void inaltimeTextIncorect(FocusEvent evt) {
        try {
            Integer.parseInt(this.inaltimeText.getText());
        } catch (NumberFormatException var3) {
            JOptionPane.showMessageDialog((Component)null, "Caracterele introduse nu au format numeric.");
            this.inaltimeText.requestFocus();
        }

    }

    private void varstaTextIncorect(FocusEvent evt) {
        try {
            Integer.parseInt(this.varstaText.getText());
        } catch (NumberFormatException var3) {
            JOptionPane.showMessageDialog((Component)null, "Caracterele introduse nu au format numeric.");
            this.varstaText.requestFocus();
        }

    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(MainDialog.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(MainDialog.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(MainDialog.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(MainDialog.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new MainDialog()).setVisible(true);
            }
        });
    }
}
