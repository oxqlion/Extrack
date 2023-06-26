/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp_oop_try1;

import java.util.ArrayList;

public class User {
    //totalUang = total uang keseluruhan
    //kalkulasi = kalkulasi pengeluaran per minggu
    
    private ArrayList<Wallet> wallet = new ArrayList<Wallet>();
//    private int totalUang;
//    private int kalkulasi;
    
    public void addWallet(Wallet nama){
        wallet.add(nama);
    }
    
//    public void minTotalUang(int uang){
//        totalUang = totalUang - uang;
//    }
    
//    public void plusTotalUang(int uang){
//        totalUang = totalUang + uang;
//    }
    
//    public int getTotalUang(){
//        return totalUang;
//    }
    
//    public void setKalkulasi(int uang){
//        kalkulasi = kalkulasi + uang;
//    }
    
//    public double getKalkulasi(){
//        return kalkulasi;
//    }
    
    public Wallet getWallet(String w){
        int index = -1;
        for(int i=0; i< wallet.size();i++){
            if(wallet.get(i).getWallet().equalsIgnoreCase(w)){
                index = i;
                break;
            }
        }
        return wallet.get(index);
    }
    
    public Wallet getWalletByID(int w){
        int index = -1;
        for(int i=0; i< wallet.size();i++){
            if(wallet.get(i).getWalletId() == w){
                index = i;
                break;
            }
        }
        return wallet.get(index);
    }
    
    public String[] getAllWallet(){
        String[] allWallet = new String[wallet.size()];
        int id = 0;
        for(Wallet w: wallet){
            allWallet[id] = w.getWallet();
            id++;
        }
        return allWallet;
    }
}
