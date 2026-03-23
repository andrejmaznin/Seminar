package gui;

import logic.Engine;
import models.*;

import javax.swing.*;
import java.util.List;

public class OrderFrame extends JDialog {
    private JLabel StewLabel;
    private JTextField StewPriceTextField;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JButton confirmButton;
    private JLabel fullNamePreview;
    private JLabel fullPricePreview;
    private JPanel contentPane;

    private Engine engine;
    private boolean confirmed = false;

    public OrderFrame(JFrame parent, Engine engine) {
        super(parent, "Заказ рагу", true);
        this.engine = engine;
        this.setContentPane(contentPane);
        this.pack();
        this.setLocationRelativeTo(parent);

        updateEngineAndPreview();

        checkBox1.addActionListener(e -> onCheckboxChange());
        checkBox2.addActionListener(e -> onCheckboxChange());
        checkBox3.addActionListener(e -> onCheckboxChange());
        checkBox4.addActionListener(e -> onCheckboxChange());

        confirmButton.addActionListener(e -> {
            confirmed = true;
            dispose();
        });
    }

    private void onCheckboxChange() {
        updateEngineAndPreview();
    }

    private void updateEngineAndPreview() {
        engine.resetCurrentOrder();
        List<JCheckBox> boxes = List.of(checkBox1, checkBox2, checkBox3, checkBox4);
        List<Class<? extends Addition>> additionClasses = List.of(DoubleDeerMeat.class, FireSauce.class, NordBread.class, SnowBerries.class);

        int selectedCount = 0;
        for (int i = 0; i < boxes.size(); i++) {
            if (boxes.get(i).isSelected()) {
                selectedCount++;
            }
        }
        boolean limitReached = selectedCount >= 3;

        int appliedCount = 0;
        for (int i = 0; i < boxes.size(); i++) {
            JCheckBox cb = boxes.get(i);
            if (cb.isSelected()) {
                if (appliedCount < 3) {
                    engine.addAddition(additionClasses.get(i));
                    appliedCount++;
                } else {
                    cb.setSelected(false);
                }
                cb.setEnabled(true);
            } else {
                cb.setEnabled(!limitReached);
            }
        }

        IStew current = engine.getCurrentOrder();
        fullNamePreview.setText(current.toString());
        fullPricePreview.setText(String.valueOf(current.checkout()));
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
