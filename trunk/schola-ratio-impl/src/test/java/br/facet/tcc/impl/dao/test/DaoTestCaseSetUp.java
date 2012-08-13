package br.facet.tcc.impl.dao.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.facet.tcc.impl.dao.EnderecoDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DaoTestCaseSetUp {

    @Autowired
    protected EnderecoDaoImpl enderecoDao;

    /**
     * @param enderecoDao
     *            the enderecoDao to set
     */
    public EnderecoDaoImpl getEnderecoDao() {
        return this.enderecoDao;
    }

}
