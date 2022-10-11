/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi;

import static Aplikasi.Aplikasi_ToDoList.ShowTodoList;

/**
 *
 * @author 
 */
public class Aplikasi_ToDoList {
public static String[]model = new String[10];
public static java.util.Scanner Scanner = new java.util.Scanner(System.in);
private static boolean channel;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //testInput();
        //testShowTodoList();
        //testaddTodoList();
        //testremoveTodoList();
       testviewShowTodoList();
        //testviewremoveTodoList();
        
    }
    //menampilkan todo list
    public static void ShowTodoList(){
        System.out.println("TODOLIST");
        for ( int i = 0; i<model.length;i++){
            String todo = model[i];
            int no = i+1;
            if (todo!= null){
                System.out.println(no+"."+todo);
        }
       }
    }
    public static void testShowTodoList(){
    ShowTodoList();
    }
    
   
    // menambah todolist
    public static void addTodoList(String todo){
        //apakah model penuh
        boolean isFull = true;
        for (int i = 0; i<model.length; i++){
            if (model[i] == null ){
                //model masih ada yang kosong
                isFull = false;
            break;
            }
        }
        for ( int i = 0; i <model.length; i++){
            if (model[i] == null ){
                    model[i] = todo;
                    break;
            }
          }
        
        // jika penuh , resize array 2x
        if(isFull){
            String[]  temp = model;
            model = new String [model.length * 2 ];
            
            System.arraycopy(temp, 0, model, 0, temp.length);
            
        }
        
        //tambahkan posisi yang data array nya null
        
        for (int i = 0; i < model.length; i++){
            if (model[i] == null){
                model [i] = todo;
                break;
            }
        }
        
    } 
    
    public static void testaddTodoList(){
         for (int i = 0; i < 25; i++){
             addTodoList("contoh todo ke."+ i);
         }
         testaddTodoList();
    }
    // menghapus todolist
     public static boolean removeTodoList(Integer number){
         if ((number - 1) >= model.length){
             return false;
         } else{
             for (int i = (number - 1); i< model.length; i++){
                 if (i == (model.length - 1)) {
                     model[i]= null;
                 }else{
                     model[i] = null;
                 }
             }
             return true;
         }
    }
     
     
     public static void testremoveTodoList(){
         addTodoList("satu");
         addTodoList("dua");
         addTodoList("tiga");
         addTodoList("empat");
         addTodoList("lima");
         
         boolean result = removeTodoList(20);
         System.out.println(result);
         
         result = removeTodoList(7);
         System.out.println(result);
         
         result = removeTodoList(2);
         System.out.println(result);
         
         
        ShowTodoList();
    }
     public static String input(String info){
         System.out.println(info + ":");
       String data  = Scanner.nextLine();
         return data;
    }
     public static void testInput(){
         String name = input ("nama");
         System.out.println("Hi  "+ name);
         
         String channel = input ("channel");
         System.out.println(channel);
     }
     
     //menampilkan menu todolist
      public static void viewShowTodoList(){
          while (true) {
              ShowTodoList();
              
              System.out.println("MENU : ");
              System.out.println("1. Tambah");
              System.out.println("2. Hapus");
              System.out.println("x. Keluar");
              
              String input = ("Pilih");
              if (input.equals("1")) {
                  viewaddTodoList();
              } else if (input.equals("2")) {
                  viewremoveTodoList();
              } else if (input.equals("x")) {
                  break;
              } else {
                  System.out.println("pilihan tidak dimengerti");
              }
          }
    }
      public static void testviewShowTodoList(){
           addTodoList("satu");
           addTodoList("dua");
           addTodoList("tiga");
           addTodoList("empat");
           addTodoList("lima");
           viewShowTodoList();
      }
           
     //menampilkan viev tambah todolist
       public static void viewaddTodoList(){
           System.out.println("menambah TODO LIST");
           
           String todo = input ("todo (x jika Batal)");
           
           if (todo.equals("x")){
               //baatal
               addTodoList(todo);
           }
    }
       
       public static void testviewaddTodoList(){
           addTodoList("satu");
           addTodoList("dua");
           viewaddTodoList();
           ShowTodoList();
       }
       
       //menampilkan hapus todolist
      public static void viewremoveTodoList(){
           System.out.println("Menghapus Todolist");
            String number = input ("nomor Dihapus (X jika batal)");
            if (number.equals("x")){
                //batal
            }else{
                boolean succes = removeTodoList(Integer.valueOf(number));
                if (!succes){
                    System.out.println("gagal menghapus Todo list :"+ number);
                    
                }
            }
      }
       public static void testviewremoveTodoList(){
                addTodoList("Satu");
                addTodoList("dua");
                
                ShowTodoList();
                
                viewremoveTodoList();
                ShowTodoList();
            }
 
} 

