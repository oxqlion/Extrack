/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp_oop_try1;

import java.util.ArrayList;
import java.util.HashMap;

public class Wallet {
    //keterangan = keterangan uang +/- untuk apa
    
    private int uangWallet, walletId;
    protected String jenisWallet;
//    private String keterangan;
    private ArrayList<History> history = new ArrayList<History>();
    private ArrayList<Integer> searchHistory = new ArrayList<Integer>();
    HashMap<String, History> ssearch = new HashMap<String, History>();
    
    public Wallet(String name, int walletId) {
        this.jenisWallet = name;
        this.walletId = walletId;
    } 
    
//    public void setWallet(String name){
//        jenisWallet = name;
//    }
    
//    public void setKeterangan(String keterangan){
//        this.keterangan = keterangan;
//    }
    
    public String getWallet(){
        return jenisWallet;
    }
    
    public void setSaldoWallet(int saldo) {
        this.uangWallet = saldo;
    }
    
//    public String getKeterangan(){
//        return keterangan;
//    }
    
    public int getUangWallet(){
        return uangWallet;
    }
    
    public void minUangWallet(int uang){
        uangWallet = uangWallet - uang;
    }
    
    public void plusUangWallet(int uang){
        uangWallet = uangWallet + uang;
    }
    
    public ArrayList<History> getHistory() {
        return this.history;
    }
    
    public void addHistory(History h) {
        history.add(h);
    }
    
    public int getWalletId() {
        return this.walletId;
    }
    
    public void saveData(String keterangan, History h){
        ssearch.put(keterangan, h);
    }
    
    public History search(String key){
        System.out.println(this.ssearch);
        if(ssearch.containsKey(key)){
            System.out.println(ssearch.get(key));
            
            History val = (History) ssearch.get(key); 
            
            System.out.println("Data search : " + val);
            
//            ArrayList<String> dataSearch = new ArrayList<String>();
//            dataSearch.add(ssearch.get(key).toString());
//            System.out.println(dataSearch);
        } else {
            System.out.println("Data tidak tersedia");
        }
        
        return ssearch.get(key);
    }
}
