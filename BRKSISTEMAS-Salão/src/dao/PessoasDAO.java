/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import to.PessoasTO;
import java.util.ArrayList;

public interface PessoasDAO {

    public String incluir(PessoasTO pessoas);

    public String alterar(PessoasTO pessoas);

    public void excluirID(long id);

    public PessoasTO consultar(String nome);

    public PessoasTO consultar(int id);

    public ArrayList<PessoasTO> consultarTodos();
}
