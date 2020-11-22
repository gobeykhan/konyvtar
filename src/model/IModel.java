package model;

import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kalucza Gabor <your.name at your.org>
 */
public interface IModel {
    
    List<Konyv> getKonyvek() throws SQLException;
    List<Konyv> getKonyvekByNev(String cim) throws SQLException;
    List<Konyv> getKonyvek(int id) throws SQLException;

    Konyv getKonyv(int id) throws SQLException;
    int addKonyv(Konyv k) throws SQLException;
    int removeKonyv(Konyv k) throws SQLException;
    int updateKonyv(Konyv k) throws SQLException;
    
      List<Tag> getTagok() throws SQLException;
       Tag getTag(int id) throws SQLException;
      int addTag(Tag t) throws SQLException;
      int removeTag(Tag t) throws SQLException;
      int updateTag(Tag t) throws SQLException;
      
      void close() throws SQLException;
      
    
    
    
    
}
