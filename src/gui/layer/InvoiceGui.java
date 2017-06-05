package gui.layer;

import control.layer.DeleteOrder;
import control.layer.ManageProductLine;
import control.layer.ReadOrder;
import model.layer.ProductLine;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

class InvoiceGui extends JFrame {


    /**
     * Create the frame.
     */
    InvoiceGui(String orderID) {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 659, 478);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(25, 93, 115));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblOrdID = new JLabel("");
        lblOrdID.setForeground(new Color(255, 255, 255));
        lblOrdID.setBounds(119, 106, 78, 14);
        contentPane.add(lblOrdID);
        lblOrdID.setText(orderID);

        DefaultTableModel invoiceTable = new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "ProductBarcode", "Quantity"
                });
        ReadOrder readOrder = new ReadOrder();
        fillTable(invoiceTable, readOrder.readProductOrder(orderID).getProductLineId());


        JLabel lblOrderId = new JLabel("OrderID:");
        lblOrderId.setForeground(new Color(255, 255, 255));
        lblOrderId.setBounds(10, 106, 78, 14);
        contentPane.add(lblOrderId);

        JLabel lblOrderStatus = new JLabel("Order Status");
        lblOrderStatus.setForeground(new Color(255, 255, 255));
        lblOrderStatus.setBounds(10, 131, 78, 14);
        contentPane.add(lblOrderStatus);

        JLabel lblOrderstatus = new JLabel("orderstatus");
        lblOrderstatus.setForeground(new Color(255, 255, 255));
        lblOrderstatus.setBounds(119, 131, 78, 14);
        contentPane.add(lblOrderstatus);
        lblOrderstatus.setText(readOrder.readProductOrder(orderID).getOrderStatus());

        JLabel lblDeliverydate = new JLabel("DeliveryDate");
        lblDeliverydate.setForeground(new Color(255, 255, 255));
        lblDeliverydate.setBounds(10, 156, 78, 14);
        contentPane.add(lblDeliverydate);

        JLabel lblDelivery = new JLabel("delivery");
        lblDelivery.setForeground(new Color(255, 255, 255));
        lblDelivery.setBounds(119, 156, 78, 14);
        contentPane.add(lblDelivery);
        lblDelivery.setText(readOrder.readProductOrder(orderID).getOrderStatus());

        JLabel lblCompanyid = new JLabel("CompanyID");
        lblCompanyid.setForeground(new Color(255, 255, 255));
        lblCompanyid.setBounds(10, 181, 78, 14);
        contentPane.add(lblCompanyid);

        JLabel lblCompanyid_1 = new JLabel("companyID");
        lblCompanyid_1.setForeground(new Color(255, 255, 255));
        lblCompanyid_1.setBounds(119, 181, 78, 14);
        contentPane.add(lblCompanyid_1);
        lblCompanyid_1.setText(readOrder.readProductOrder(orderID).getCompanyId());

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(313, 0, 330, 439);
        contentPane.add(scrollPane);

        JTable table = new JTable();
        table.setBackground(new Color(62, 143, 169));
        scrollPane.setViewportView(table);
        table.setModel(invoiceTable);

        JLabel lblTotalTime = new JLabel("Total time");
        lblTotalTime.setForeground(new Color(255, 255, 255));
        lblTotalTime.setBounds(10, 230, 78, 14);
        contentPane.add(lblTotalTime);

        JLabel lblTime = new JLabel("time");
        lblTime.setForeground(new Color(255, 255, 255));
        lblTime.setBounds(119, 230, 78, 14);
        contentPane.add(lblTime);
        lblTime.setText("" + readOrder.readProductOrder(orderID).getTotalProductionTime());

        JLabel lblTotalPrice = new JLabel("Total Price");
        lblTotalPrice.setForeground(new Color(255, 255, 255));
        lblTotalPrice.setBounds(10, 269, 78, 14);
        contentPane.add(lblTotalPrice);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setForeground(new Color(255, 255, 255));
        lblPrice.setBounds(119, 269, 78, 14);
        contentPane.add(lblPrice);
        lblPrice.setText("" + readOrder.readProductOrder(orderID).getTotalPrice());

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(2, 52, 68));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();
                ProductOrderGui productOrderGui = new ProductOrderGui();
                productOrderGui.setVisible(true);
            }
        });
        btnBack.setBounds(21, 348, 89, 23);
        contentPane.add(btnBack);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(2, 52, 68));
        btnCancel.setForeground(new Color(255, 255, 255));
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeleteOrder deleteOrder = new DeleteOrder();
                deleteOrder.deleteProductOrder(lblOrdID.getText());
                dispose();
                ProductOrderGui productOrderGui = new ProductOrderGui();
                productOrderGui.setVisible(true);
            }
        });
        btnCancel.setBounds(158, 348, 89, 23);
        contentPane.add(btnCancel);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBackground(new Color(2, 52, 68));
        btnConfirm.setForeground(new Color(255, 255, 255));
        btnConfirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                Menu menu = new Menu();
                menu.setVisible(true);
            }
        });
        btnConfirm.setBounds(84, 405, 89, 23);
        contentPane.add(btnConfirm);
        
        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("photos\\invoice.png"));
        label.setBounds(10, 10, 316, 85);
        contentPane.add(label);

    }

    private void fillTable(DefaultTableModel model, String productLineID) {
        model.setRowCount(0);
        ManageProductLine productLineCtr = new ManageProductLine();
        ArrayList<ProductLine> productLines = productLineCtr.readAll();
        if (!productLines.isEmpty()) {
            for (ProductLine productLine : productLines) {
                if (productLine.getproductLineId().equals(productLineID)) {
                    double quantity = productLine.getQuantity();
                    String productBarcode = productLine.getProductBarcode();
                    model.addRow(new Object[]{productBarcode, quantity});
                }
            }

        } else {
            model.addRow(new Object[]{"Product Lines", "FOUND"});
        }
    }
}

