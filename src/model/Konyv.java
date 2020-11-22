/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kalucza Gabor <your.name at your.org>
 */
public class Konyv {

    private int id;
    private String szerzo;
    private String cim;
    private int oldalszam;
    private int tag_id;

    public Konyv() {

    }

    public Konyv(int id, String szerzo, String cim, int oldalszam, int tag_id) {
        this.id = id;
        this.szerzo = szerzo;
        this.cim = cim;
        this.oldalszam = oldalszam;
        this.tag_id = tag_id;
    }

    public Konyv(String szerzo, String cim, int oldalszam, int tag_id) {
        this.szerzo = szerzo;
        this.cim = cim;
        this.oldalszam = oldalszam;
        this.tag_id = tag_id;
    }

    @Override
    public String toString() {
        return cim + " (" + szerzo + ")";
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public void setSzerzo(String szerzo) {
        this.szerzo = szerzo;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public int getOldalszam() {
        return oldalszam;
    }

    public void setOldalszam(int oldalszam) {
        this.oldalszam = oldalszam;
    }

}
