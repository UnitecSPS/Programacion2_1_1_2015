/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.io.Serializable;

/**
 *
 * @author Docente 17082011
 */
public interface ChaturangaActions extends Serializable, Cloneable, Printeable {
    boolean createUser(String u);
    String getUser(String u);
    void editUser(String old, String newval);
}
