package com.mycompany.mavenproject2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String[] args) {
        
         Socket  socket = null;
         ServerSocket socketservidor = null;
            
        try {   
            
            socketservidor = new ServerSocket(5010);
            socket = socketservidor.accept();
            
            DataInputStream recebido = new DataInputStream(socket.getInputStream());
            DataOutputStream enviado = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("(cliente): "+recebido.readUTF());
            enviado.writeUTF("O Servidor Recebeu sua Mensagem");
            
        } catch (IOException ex) {
            
            System.err.println("Falha na Conexão");
            
        }finally{
        
            try{
                socket.close();
                socketservidor.close();
            }catch(IOException ex){
                 System.err.println("Falha ao encerrar a conexao");
            }  
            
        }
    }
}
