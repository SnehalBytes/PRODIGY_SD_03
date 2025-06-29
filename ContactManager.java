package task3;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ContactManager extends Applet implements ActionListener {
    private TextField nameField, phoneField, emailField;
    private TextArea contactListArea;
    private ArrayList<String> contacts;
    private Button addButton, clearButton;

    public void init() {
        setLayout(new FlowLayout());

        Label nameLabel = new Label("Name:");
        Label phoneLabel = new Label("Phone:");
        Label emailLabel = new Label("Email:");

        nameField = new TextField(20);
        phoneField = new TextField(15);
        emailField = new TextField(20);

        addButton = new Button("Add Contact");
        clearButton = new Button("Clear List");

        contactListArea = new TextArea(10, 40);
        contacts = new ArrayList<>();

        add(nameLabel);
        add(nameField);
        add(phoneLabel);
        add(phoneField);
        add(emailLabel);
        add(emailField);
        add(addButton);
        add(clearButton);
        add(contactListArea);

        addButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String contact = nameField.getText() + " | " + phoneField.getText() + " | " + emailField.getText();
            contacts.add(contact);
            updateContactList();
        } else if (e.getSource() == clearButton) {
            contacts.clear();
            updateContactList();
        }
    }

    private void updateContactList() {
        contactListArea.setText("");
        for (String contact : contacts) {
            contactListArea.append(contact + "\n");
        }
    }
}