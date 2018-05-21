/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import to.PessoasTO;
import java.util.ArrayList;

public interface PessoasDAO {
    
    public String Incluir(PessoasTO pessoas);
    public String Alterar(PessoasTO pessoas);
    public void ExcluirID(long id);
    public PessoasTO Consultar(String nome);
    public PessoasTO Consultar(int id);
    public ArrayList<PessoasTO> ConsultarTodos();
    
}
