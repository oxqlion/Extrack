/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alp_oop_try1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Rafi Abhista
 */
public class History {

    private int nominal;
    private String desc, keterangan;

    private LocalDate date;
    private LocalTime time;

    public History(int nominal, String desc, LocalDate date, LocalTime time, String keterangan) {
        this.nominal = nominal;
        this.desc = desc;
        this.date = date;
        this.time = time;
        this.keterangan = keterangan;
    }

    public int getHistoryNominal() {
        return this.nominal;
    }

    public String[] getHistory() {
        String[] arr = {Integer.toString(this.nominal), this.desc, this.date.toString(), this.time.toString(), this.keterangan};
        return arr;
    }
}
