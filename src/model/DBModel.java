/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kalucza Gabor <your.name at your.org>
 */
public class DBModel implements IModel {

    private Connection conn;

    private PreparedStatement getKonyvekPstmt;
    private PreparedStatement getKonyvekByNev;
    private PreparedStatement getKonyvekByTagPstmt;
    private PreparedStatement getKonyvPstmt;
    private PreparedStatement addKonyvPstmt;
    private PreparedStatement removeKonyvPstmt;
    private PreparedStatement updateKonyvPstmt;

    private PreparedStatement getTagokPstmt;
    private PreparedStatement getTagPstmt;
    private PreparedStatement addTagPstmt;
    private PreparedStatement removeTagPstmt;
    private PreparedStatement updateTagPstmt;

    public DBModel(Connection conn) throws SQLException {

        this.conn = conn;

        getKonyvekPstmt = conn.prepareStatement("SELECT * FROM konyv");
        getKonyvekByNev = conn.prepareStatement("SELECT * FROM konyv WHERE cim LIKE ?");
        
        getKonyvekByTagPstmt = conn.prepareStatement("SELECT * FROM konyv WHERE tag_id=?");
        getKonyvPstmt = conn.prepareStatement("SELECT * FROM konyv WHERE id=?");
        addKonyvPstmt = conn.prepareStatement(
                "INSERT INTO konyv (szerzo,cim,oldalszam,tag_id) VALUES (?,?,?,?)");
        removeKonyvPstmt = conn.prepareStatement("DELETE FROM konyv WHERE id=?");
        updateKonyvPstmt = conn.prepareStatement("UPDATE konyv SET szerzo=?,cim=?,oldalszam=? WHERE id=?");

        getTagokPstmt = conn.prepareStatement("SELECT * FROM tag");
        getTagPstmt = conn.prepareStatement("SELECT * from TAG where id=?");
        addTagPstmt = conn.prepareStatement("INSERT INTO tag (nev,email) VALUES(?,?)");
        removeTagPstmt = conn.prepareStatement("DELETE FROM tag WHERE id=?");
        updateTagPstmt = conn.prepareStatement("UPDATE tag SET nev=?,email=? WHERE id=?");

    }

    @Override
    public List<Konyv> getKonyvek() throws SQLException {

        List<Konyv> konyvek = new ArrayList<>();

        ResultSet rs = getKonyvekPstmt.executeQuery();

        while (rs.next()) {
            konyvek.add(new Konyv(
                    rs.getInt("id"),
                    rs.getString("szerzo"),
                    rs.getString("cim"),
                    rs.getInt("oldalszam"),
                    rs.getInt("tag_id")));
        }

        rs.close();
        return konyvek;
    }
    @Override
    public List<Konyv> getKonyvekByNev(String cim) throws SQLException {
       List<Konyv> konyvek = new ArrayList<>();

       getKonyvekByNev.setString(1, "%"+cim+"%");
        ResultSet rs = getKonyvekByNev.executeQuery();

        while (rs.next()) {
            konyvek.add(new Konyv(
                    rs.getInt("id"),
                    rs.getString("szerzo"),
                    rs.getString("cim"),
                    rs.getInt("oldalszam"),
                    rs.getInt("tag_id")));
        }

        rs.close();
        return konyvek;
    }

    @Override
    public List<Konyv> getKonyvek(int id) throws SQLException {
        List<Konyv> konyvek = new ArrayList<>();
        getKonyvekByTagPstmt.setInt(1, id);

        ResultSet rs = getKonyvekByTagPstmt.executeQuery();

        while (rs.next()) {
            konyvek.add(new Konyv(
                    rs.getInt("id"),
                    rs.getString("szerzo"),
                    rs.getString("cim"),
                    rs.getInt("oldalszam"),
                    rs.getInt("tag_id")));

        }

        rs.close();
        return konyvek;
    }

    @Override
    public Konyv getKonyv(int id) throws SQLException {

        getKonyvPstmt.setInt(1, id);

        ResultSet rs = getKonyvPstmt.executeQuery();

        Konyv konyv = null;

        while (rs.next()) {
            konyv = new Konyv(
                    rs.getInt("id"),
                    rs.getString("szerzo"),
                    rs.getString("cim"),
                    rs.getInt("oldalszam"),
                    rs.getInt("tag_id"));

        }

        rs.close();
        return konyv;
    }

    @Override
    public int addKonyv(Konyv k) throws SQLException {

        addKonyvPstmt.setString(1, k.getSzerzo());
        addKonyvPstmt.setString(2, k.getCim());
        addKonyvPstmt.setInt(3, k.getOldalszam());
        addKonyvPstmt.setInt(4, k.getTag_id());

        return addKonyvPstmt.executeUpdate();

    }

    @Override
    public int removeKonyv(Konyv k) throws SQLException {
        removeKonyvPstmt.setInt(1, k.getId());

        return removeKonyvPstmt.executeUpdate();
    }

    @Override
    public int updateKonyv(Konyv k) throws SQLException {

        updateKonyvPstmt.setString(1, k.getSzerzo());
        updateKonyvPstmt.setString(2, k.getCim());
        updateKonyvPstmt.setInt(3, k.getOldalszam());
        updateKonyvPstmt.setInt(4, k.getId());

        return updateKonyvPstmt.executeUpdate();

    }

    @Override
    public List<Tag> getTagok() throws SQLException {

        List<Tag> tagok = new ArrayList<>();

        ResultSet rs = getTagokPstmt.executeQuery();

        while (rs.next()) {
            tagok.add(
                    new Tag(
                            rs.getInt("id"),
                            rs.getString("nev"),
                            rs.getString("email")));
        }

        rs.close();
        return tagok;

    }

    @Override
    public Tag getTag(int id) throws SQLException {
        getTagPstmt.setInt(1, id);

        ResultSet rs = getTagPstmt.executeQuery();

        Tag tag = null;

        while (rs.next()) {
            tag = new Tag(
                    rs.getInt("id"),
                    rs.getString("nev"),
                    rs.getString("email")
            );
        }

        rs.close();
        return tag;

    }

    @Override
    public int addTag(Tag t) throws SQLException {
        addTagPstmt.setString(1, t.getNev());
        addTagPstmt.setString(2, t.getEmail());

        return addTagPstmt.executeUpdate();
    }

    @Override
    public int removeTag(Tag t) throws SQLException {

        removeTagPstmt.setInt(1, t.getId());

        return removeTagPstmt.executeUpdate();
    }

    @Override
    public int updateTag(Tag t) throws SQLException {
        
        
        
        updateTagPstmt.setString(1, t.getNev());
        updateTagPstmt.setString(2, t.getEmail());
        updateKonyvPstmt.setInt(3, t.getId());
        
        return updateKonyvPstmt.executeUpdate();
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }

    

}
