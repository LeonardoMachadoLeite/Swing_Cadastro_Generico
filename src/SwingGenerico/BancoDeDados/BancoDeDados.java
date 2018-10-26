/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SwingGenerico.BancoDeDados;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Efraim
 */
public class BancoDeDados {
    private String databaseURL = "jdbc:sqlite:banco_de_dados.db";
    private ConnectionSource connectionSource;
    private HashMap<Class, Dao> Daos;
    private static BancoDeDados instance = new BancoDeDados();
    private BancoDeDados() {
        try {
            this.connectionSource = new JdbcConnectionSource(databaseURL);
        } catch (SQLException ex) {
            System.err.println("Banco de Dados não inicializado");
            ex.printStackTrace();
        }
        this.Daos = new HashMap<>();
    };
    public <E, C> boolean criarConnection(Class<E> classeElemento, Class<C> classeChave) throws SQLException {
        if (this.Daos.containsKey(classeElemento)) {
            return false;
        } else {
            Dao<E, C> newDao = DaoManager.createDao(this.connectionSource, classeElemento);
            TableUtils.createTableIfNotExists(connectionSource, classeElemento);
            this.Daos.put(classeElemento, newDao);
            return true;
        }
    }
    public void closeConnection() throws IOException {
        this.connectionSource.close();
    }
    public <T> boolean criarObject(T obj, Class<T> classe) throws SQLException {
        if (this.Daos.containsKey(classe)) {
            Dao dao = this.Daos.get(classe);
            dao.createOrUpdate(obj);
            return true;
        }
        return false;
    }
    public <E, C> E getObject(C chave, Class<E> classeElemento) throws SQLException {
        Dao dao = this.Daos.get(classeElemento);
        return classeElemento.cast(dao.queryForId(chave));
    }
    public <E> boolean updateObject(E object, Class<E> classeObj) throws SQLException {
        if (this.Daos.containsKey(classeObj)) {
            Dao dao = this.Daos.get(classeObj);
            int rows = dao.update(object);
            if (rows == 1) {
                return true;
            }
        }
        return false;
    }
    public <E> boolean deleteObject(E object, Class<E> classeObj) throws SQLException {
        if (this.Daos.containsKey(classeObj)) {
            Dao dao = this.Daos.get(classeObj);
            int rows = dao.delete(object);
            if (rows == 1) {
                return true;
            }
        }
        return false;
    }
    public <K> boolean deleteObjectById(K id, Class classeObj) throws SQLException {
        if (this.Daos.containsKey(classeObj)) {
            int rows = this.Daos.get(classeObj).deleteById(id);
            if (rows > 0) {
                return true;
            }
        }
        return false;
    }
    public <E> ArrayList<E> getObjectList(Class<E> classeElementos) {
        if (this.Daos.containsKey(classeElementos)) {
            Iterator<E> itr = this.Daos.get(classeElementos).iterator();
            ArrayList<E> ans = new ArrayList<>();
            while (itr.hasNext()) {
                ans.add(itr.next());
            }
            return ans;
        }
        return null;
    }
    public static BancoDeDados getInstance() {
        return instance;
    }
}
