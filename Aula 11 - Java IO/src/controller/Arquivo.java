package controller;

import model.Funcionario;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    public void escrever(Funcionario func){

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        String linhaEscrever;

        // bloco try catch para caso tenha algo de errado na escrita do funcionario no arquivo.txt
        try{

            os = new FileOutputStream("Funcionario.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Funcionario");
            bw.newLine();
            bw.write(func.nome + "\n");
            bw.write(func.idade + "\n");
            bw.write(func.cpf + "\n");

        }catch(Exception e){
            System.out.println(e);

        }finally {
// bloco try catch para tentar fechar a entrada de dados
            try {
                bw.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }

    public ArrayList<Funcionario> ler(){

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linhaLer;

        // bloco try catch para tentar ler um arquivo
        try{

            is = new FileInputStream("Funcionario.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();
            while(linhaLer != null){
                if(linhaLer.contains("Funcionario")){
                    Funcionario f = new Funcionario();
                    f.nome = br.readLine();
                    f.idade = Integer.parseInt(br.readLine());
                    f.cpf = br.readLine();
                    funcionarios.add(f);
                }
                linhaLer = br.readLine();
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {

            // bloco try catch para tentar fechar a leitura de dados
            try{
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }


        return funcionarios;
    }

}
