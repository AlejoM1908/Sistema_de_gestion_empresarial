/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic_interfaces;

import classes.data_structures.*;
import classes.others.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.simple.parser.*;
import org.json.simple.*;

public class SystemLogin extends javax.swing.JFrame {
    static AVLTree<User> usersTree = new AVLTree<>();
    
    private void ChargeUsers(){
        JSONParser parser = new JSONParser();
        
        try{
            //Reading JSON file
            Object obj = parser.parse(new FileReader("src/json_files/Users.json"));
 
            JSONArray list = (JSONArray) obj;
  
            //Iterate over employee array
            list.forEach(user -> parceUsers((JSONObject) user));
        }
        catch(FileNotFoundException e){
            System.out.println("El Archivo no fue encontrado");
        }
        catch(IOException e){}
        catch(ParseException e){}
    }
    
    public void parceUsers(JSONObject object){
        //Getting User nickname from object
        String nickname = (String) object.get("Nickname");
        String password = (String) object.get("Password");
        String email = (String) object.get("Email");
        String type = (String) object.get("Type");
        
        usersTree.Insert(new User(nickname, password, email, type));
    }
    
    private void SaveUsers(){
        Queue<User> result = new Queue<>();
        usersTree.InOrder(usersTree.getRoot(), result);
        JSONArray usersArray = new JSONArray();
        
        while(!result.IsEmpty()){
            User saveUser = result.Dequeue();
            
            JSONObject user = new JSONObject();
            
            user.put("Nickname", saveUser.getNickname());
            user.put("Password", saveUser.getPassword());
            user.put("Email", saveUser.getEmail());
            user.put("Type", saveUser.getType());
            
            usersArray.add(user);
        }
        
        
        try(FileWriter JSONFile = new FileWriter("src/json_files/Users.json")){
            JSONFile.write(usersArray.toString());
            JSONFile.flush();
        }
        catch(IOException e){
            System.out.println("Exception executed");
        }
    }
    
    /**
     * Creates new form SystemLogin
     */
    public SystemLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/images/Icon_App.png")).getImage());
        ChargeUsers();
       
        Panel_SystemLogin.setVisible(true);
        Panel_NewUser.setVisible(false);
        NewPasswordField.setEchoChar('*');
        ConfirmNewPasswordField.setEchoChar('*');
        PasswordField.setEchoChar('*');
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_NewUser = new javax.swing.JPanel();
        Label_ReturnButton = new javax.swing.JLabel();
        Label_NewUserIcon = new javax.swing.JLabel();
        Label_NewUser = new javax.swing.JLabel();
        Label_NewUserIcon_02 = new javax.swing.JLabel();
        Text_NewUser = new javax.swing.JTextField();
        Separator_NewUser = new javax.swing.JSeparator();
        Label_NewPassword = new javax.swing.JLabel();
        Label_NewPasswordIcon = new javax.swing.JLabel();
        NewPasswordField = new javax.swing.JPasswordField();
        Separator_NewPassword = new javax.swing.JSeparator();
        Label_ConfirmNewPassword = new javax.swing.JLabel();
        Label_ConfirmNewPassword_02 = new javax.swing.JLabel();
        ConfirmNewPasswordField = new javax.swing.JPasswordField();
        Separator_ConfirmNewPassword = new javax.swing.JSeparator();
        Label_Email = new javax.swing.JLabel();
        Label_EmailIcon = new javax.swing.JLabel();
        Text_Email = new javax.swing.JTextField();
        Separator_Email = new javax.swing.JSeparator();
        Label_CreateUserButton = new javax.swing.JLabel();
        Panel_SystemLogin = new javax.swing.JPanel();
        Label_ExitButton = new javax.swing.JLabel();
        Label_UserIcon = new javax.swing.JLabel();
        LabelUser = new javax.swing.JLabel();
        LabelUserIcon2 = new javax.swing.JLabel();
        TextUser = new javax.swing.JTextField();
        SeparatorUser = new javax.swing.JSeparator();
        LabelPassword = new javax.swing.JLabel();
        LabelPasswordIcon = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        SeparatorPassword = new javax.swing.JSeparator();
        Label_LoginButton = new javax.swing.JLabel();
        Label_NewUserButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_NewUser.setBackground(new java.awt.Color(255, 255, 255));
        Panel_NewUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        Label_ReturnButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_BackOrange_32px.png"))); // NOI18N
        Label_ReturnButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Label_ReturnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ReturnButtonMouseClicked(evt);
            }
        });

        Label_NewUserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_User_96px.png"))); // NOI18N

        Label_NewUser.setBackground(new java.awt.Color(255, 255, 255));
        Label_NewUser.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_NewUser.setForeground(new java.awt.Color(255, 99, 71));
        Label_NewUser.setText("Nuevo Usuario:");

        Label_NewUserIcon_02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_User_32px.png"))); // NOI18N

        Text_NewUser.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        Text_NewUser.setForeground(new java.awt.Color(130, 130, 130));
        Text_NewUser.setBorder(null);

        Separator_NewUser.setForeground(new java.awt.Color(130, 130, 130));

        Label_NewPassword.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_NewPassword.setForeground(new java.awt.Color(255, 99, 71));
        Label_NewPassword.setText("Nueva Contraseña:");

        Label_NewPasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_Key_32px.png"))); // NOI18N

        NewPasswordField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        NewPasswordField.setForeground(new java.awt.Color(130, 130, 130));
        NewPasswordField.setBorder(null);

        Separator_NewPassword.setForeground(new java.awt.Color(130, 130, 130));

        Label_ConfirmNewPassword.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_ConfirmNewPassword.setForeground(new java.awt.Color(255, 99, 71));
        Label_ConfirmNewPassword.setText("Confirmar Contraseña:");

        Label_ConfirmNewPassword_02.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_Key_32px.png"))); // NOI18N

        ConfirmNewPasswordField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        ConfirmNewPasswordField.setForeground(new java.awt.Color(130, 130, 130));
        ConfirmNewPasswordField.setBorder(null);

        Separator_ConfirmNewPassword.setForeground(new java.awt.Color(130, 130, 130));

        Label_Email.setBackground(new java.awt.Color(255, 255, 255));
        Label_Email.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_Email.setForeground(new java.awt.Color(255, 99, 71));
        Label_Email.setText("Email:");

        Label_EmailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_OrangeEmail_32px.png"))); // NOI18N

        Text_Email.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        Text_Email.setForeground(new java.awt.Color(130, 130, 130));
        Text_Email.setBorder(null);

        Separator_Email.setForeground(new java.awt.Color(130, 130, 130));

        Label_CreateUserButton.setBackground(new java.awt.Color(255, 99, 71));
        Label_CreateUserButton.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_CreateUserButton.setForeground(new java.awt.Color(255, 255, 255));
        Label_CreateUserButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_CreateUserButton.setText("Crear");
        Label_CreateUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Label_CreateUserButton.setOpaque(true);
        Label_CreateUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_CreateUserButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_NewUserLayout = new javax.swing.GroupLayout(Panel_NewUser);
        Panel_NewUser.setLayout(Panel_NewUserLayout);
        Panel_NewUserLayout.setHorizontalGroup(
            Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_NewUserLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Separator_ConfirmNewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(Separator_NewUser)
                            .addComponent(Separator_NewPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addComponent(Label_NewUserIcon_02)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Text_NewUser))
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addComponent(Label_NewPasswordIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NewPasswordField))
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addComponent(Label_ConfirmNewPassword_02)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmNewPasswordField))
                            .addComponent(Separator_Email)
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addComponent(Label_EmailIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Text_Email))
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Label_NewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_NewUser, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_ConfirmNewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Label_Email, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(Panel_NewUserLayout.createSequentialGroup()
                        .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(Label_CreateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Label_ReturnButton)
                                .addGap(76, 76, 76)
                                .addComponent(Label_NewUserIcon)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_NewUserLayout.setVerticalGroup(
            Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_NewUserLayout.createSequentialGroup()
                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_NewUserIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_NewUserLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_ReturnButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_NewUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_NewUserIcon_02)
                    .addComponent(Text_NewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator_NewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Label_NewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_NewPasswordIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator_NewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(Label_ConfirmNewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_ConfirmNewPassword_02))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator_ConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_NewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_EmailIcon)
                    .addComponent(Text_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_CreateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        getContentPane().add(Panel_NewUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 490));

        Panel_SystemLogin.setBackground(new java.awt.Color(255, 255, 255));
        Panel_SystemLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        Panel_SystemLogin.setForeground(new java.awt.Color(255, 255, 255));

        Label_ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_OrangeExitDoor_32px.png"))); // NOI18N
        Label_ExitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Label_ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ExitButtonMouseClicked(evt);
            }
        });

        Label_UserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_User_96px.png"))); // NOI18N

        LabelUser.setBackground(new java.awt.Color(255, 255, 255));
        LabelUser.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        LabelUser.setForeground(new java.awt.Color(255, 99, 71));
        LabelUser.setText("Usuario:");

        LabelUserIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon_User_32px.png"))); // NOI18N

        TextUser.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        TextUser.setForeground(new java.awt.Color(130, 130, 130));
        TextUser.setBorder(null);

        SeparatorUser.setForeground(new java.awt.Color(130, 130, 130));

        LabelPassword.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        LabelPassword.setForeground(new java.awt.Color(255, 99, 71));
        LabelPassword.setText("Contraseña:");

        LabelPasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon_Key_32px.png"))); // NOI18N

        PasswordField.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(130, 130, 130));
        PasswordField.setBorder(null);

        SeparatorPassword.setForeground(new java.awt.Color(130, 130, 130));

        Label_LoginButton.setBackground(new java.awt.Color(255, 99, 71));
        Label_LoginButton.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        Label_LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        Label_LoginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_LoginButton.setText("Ingresar");
        Label_LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Label_LoginButton.setOpaque(true);
        Label_LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_LoginButtonMouseClicked(evt);
            }
        });

        Label_NewUserButton.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        Label_NewUserButton.setForeground(new java.awt.Color(255, 99, 71));
        Label_NewUserButton.setText("Crear un nuevo Usuario");
        Label_NewUserButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Label_NewUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_NewUserButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_SystemLoginLayout = new javax.swing.GroupLayout(Panel_SystemLogin);
        Panel_SystemLogin.setLayout(Panel_SystemLoginLayout);
        Panel_SystemLoginLayout.setHorizontalGroup(
            Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_SystemLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_SystemLoginLayout.createSequentialGroup()
                        .addComponent(Label_UserIcon)
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_SystemLoginLayout.createSequentialGroup()
                        .addComponent(Label_ExitButton)
                        .addContainerGap())))
            .addGroup(Panel_SystemLoginLayout.createSequentialGroup()
                .addGroup(Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_SystemLoginLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SeparatorPassword)
                            .addComponent(SeparatorUser, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_SystemLoginLayout.createSequentialGroup()
                                .addGroup(Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(LabelPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelUser, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_SystemLoginLayout.createSequentialGroup()
                                        .addComponent(LabelPasswordIcon)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Panel_SystemLoginLayout.createSequentialGroup()
                                .addComponent(LabelUserIcon2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextUser))))
                    .addGroup(Panel_SystemLoginLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(Label_LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_SystemLoginLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Label_NewUserButton)
                .addGap(89, 89, 89))
        );
        Panel_SystemLoginLayout.setVerticalGroup(
            Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_SystemLoginLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(Label_ExitButton)
                .addGap(18, 18, 18)
                .addComponent(Label_UserIcon)
                .addGap(30, 30, 30)
                .addComponent(LabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelUserIcon2)
                    .addComponent(TextUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparatorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_SystemLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelPasswordIcon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparatorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Label_LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_NewUserButton)
                .addGap(40, 40, 40))
        );

        getContentPane().add(Panel_SystemLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton de salida
    private void Label_ExitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ExitButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_Label_ExitButtonMouseClicked

    //Boton para comprobar credenciales
    private void Label_LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_LoginButtonMouseClicked
        String nickname = TextUser.getText();
        char[] passwordToConvert = PasswordField.getPassword();
        String password = "";
        
        for (int i=0; i<passwordToConvert.length; i++){
            password += passwordToConvert[i];
        }
        
        User foundedUser = usersTree.getKey(usersTree.Find(new User(nickname, password), usersTree.getRoot()));
        
        if (foundedUser.getNickname().compareTo(nickname) == 0){
            if (foundedUser.getPassword().compareTo(password) == 0){
                PrincipalInterface principal = new PrincipalInterface(foundedUser.getType());
                this.setVisible(false);
                principal.setVisible(true);
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden con las registradas, intente nuevamente");
                PasswordField.setText("");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "El usuario ingresado no existe o fue escrito incorrectamente");
            PasswordField.setText("");
        }
    }//GEN-LAST:event_Label_LoginButtonMouseClicked

    //Boton para cambiar a interfaz de creacion de usuarios
    private void Label_NewUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_NewUserButtonMouseClicked
        Panel_NewUser.setVisible(true);
        Panel_SystemLogin.setVisible(false);
        
        Text_NewUser.setText("");
        NewPasswordField.setText("");
        ConfirmNewPasswordField.setText("");
        Text_Email.setText("");
    }//GEN-LAST:event_Label_NewUserButtonMouseClicked

    //Boton para crear un nuevo usuario
    private void Label_CreateUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_CreateUserButtonMouseClicked
        usersTree.Insert(new User("root","0000","root@root.user.com","Master"));
        usersTree.Insert(new User("Admin","1234","iamtheadmin@admin.com","Master"));
    }//GEN-LAST:event_Label_CreateUserButtonMouseClicked

    //Boton para volver al login
    private void Label_ReturnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ReturnButtonMouseClicked
        Panel_NewUser.setVisible(false);
        Panel_SystemLogin.setVisible(true);
        
        Text_NewUser.setText("");
        NewPasswordField.setText("");
        ConfirmNewPasswordField.setText("");
        Text_Email.setText("");
    }//GEN-LAST:event_Label_ReturnButtonMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SystemLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmNewPasswordField;
    private javax.swing.JLabel LabelPassword;
    private javax.swing.JLabel LabelPasswordIcon;
    private javax.swing.JLabel LabelUser;
    private javax.swing.JLabel LabelUserIcon2;
    private javax.swing.JLabel Label_ConfirmNewPassword;
    private javax.swing.JLabel Label_ConfirmNewPassword_02;
    private javax.swing.JLabel Label_CreateUserButton;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_EmailIcon;
    private javax.swing.JLabel Label_ExitButton;
    private javax.swing.JLabel Label_LoginButton;
    private javax.swing.JLabel Label_NewPassword;
    private javax.swing.JLabel Label_NewPasswordIcon;
    private javax.swing.JLabel Label_NewUser;
    private javax.swing.JLabel Label_NewUserButton;
    private javax.swing.JLabel Label_NewUserIcon;
    private javax.swing.JLabel Label_NewUserIcon_02;
    private javax.swing.JLabel Label_ReturnButton;
    private javax.swing.JLabel Label_UserIcon;
    private javax.swing.JPasswordField NewPasswordField;
    private javax.swing.JPanel Panel_NewUser;
    private javax.swing.JPanel Panel_SystemLogin;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JSeparator SeparatorPassword;
    private javax.swing.JSeparator SeparatorUser;
    private javax.swing.JSeparator Separator_ConfirmNewPassword;
    private javax.swing.JSeparator Separator_Email;
    private javax.swing.JSeparator Separator_NewPassword;
    private javax.swing.JSeparator Separator_NewUser;
    private javax.swing.JTextField TextUser;
    private javax.swing.JTextField Text_Email;
    private javax.swing.JTextField Text_NewUser;
    // End of variables declaration//GEN-END:variables
}
