package br.facet.tcc.impl.dao.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.facet.tcc.impl.dao.AlunoCursoDaoImpl;
import br.facet.tcc.impl.dao.AlunoDaoImpl;
import br.facet.tcc.impl.dao.AvaliacaoDaoImpl;
import br.facet.tcc.impl.dao.AvaliacaoDeAlunoDaoImpl;
import br.facet.tcc.impl.dao.CursoDaoImpl;
import br.facet.tcc.impl.dao.DescontoDaoImpl;
import br.facet.tcc.impl.dao.DisciplinaDaoImpl;
import br.facet.tcc.impl.dao.EnderecoDaoImpl;
import br.facet.tcc.impl.dao.InstituicaoDaoImpl;
import br.facet.tcc.impl.dao.MensalidadeDaoImpl;
import br.facet.tcc.impl.dao.PermissaoDaoImpl;
import br.facet.tcc.impl.dao.ProfessorDaoImpl;
import br.facet.tcc.impl.dao.SituacaoDoAlunoNaTurmaDaoImpl;
import br.facet.tcc.impl.dao.TurmaDaoImpl;
import br.facet.tcc.impl.dao.UserLoginDaoImpl;
import br.facet.tcc.impl.dao.UsuarioDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DaoTestCaseSetUp {

    @Autowired
    protected AlunoDaoImpl alunoDao;

    @Autowired
    protected AlunoCursoDaoImpl alunoCursoDao;

    @Autowired
    protected AvaliacaoDaoImpl avaliacaoDao;

    @Autowired
    protected AvaliacaoDeAlunoDaoImpl avaliacaoDeAlunoDao;

    @Autowired
    protected CursoDaoImpl cursoDao;

    @Autowired
    protected DescontoDaoImpl descontoDao;

    @Autowired
    protected DisciplinaDaoImpl disciplinaDao;

    @Autowired
    protected EnderecoDaoImpl enderecoDao;

    @Autowired
    protected InstituicaoDaoImpl instituicaoDao;

    @Autowired
    protected MensalidadeDaoImpl mensalidadeDao;

    @Autowired
    protected PermissaoDaoImpl permissaoDao;

    @Autowired
    protected ProfessorDaoImpl professorDao;

    @Autowired
    protected SituacaoDoAlunoNaTurmaDaoImpl situacaoDoAlunoNaTurmaDao;

    @Autowired
    protected TurmaDaoImpl turmaDao;

    @Autowired
    protected UserLoginDaoImpl userLoginDao;

    @Autowired
    protected UsuarioDaoImpl usuarioDao;

    /**
     * @param enderecoDao
     *            the enderecoDao to set
     */
    public EnderecoDaoImpl getEnderecoDao() {
        return this.enderecoDao;
    }

    /**
     * @return the alunoDao
     */
    public AlunoDaoImpl getAlunoDao() {
        return alunoDao;
    }

    /**
     * @return the avaliacaoDao
     */
    public AvaliacaoDaoImpl getAvaliacaoDao() {
        return avaliacaoDao;
    }

    /**
     * @return the avaLiacaoDeAlunoDao
     */
    public AvaliacaoDeAlunoDaoImpl getAvaLiacaoDeAlunoDao() {
        return avaliacaoDeAlunoDao;
    }

    /**
     * @return the cursoDao
     */
    public CursoDaoImpl getCursoDao() {
        return cursoDao;
    }

    /**
     * @return the disciplinaDao
     */
    public DisciplinaDaoImpl getDisciplinaDao() {
        return disciplinaDao;
    }

    /**
     * @return the instituicaoDao
     */
    public InstituicaoDaoImpl getInstituicaoDao() {
        return instituicaoDao;
    }

    /**
     * @return the mensalidadeDao
     */
    public MensalidadeDaoImpl getMensalidadeDao() {
        return mensalidadeDao;
    }

    /**
     * @return the professorDao
     */
    public ProfessorDaoImpl getProfessorDao() {
        return professorDao;
    }

    /**
     * @return the turmaDao
     */
    public TurmaDaoImpl getTurmaDao() {
        return turmaDao;
    }

    /**
     * @return the usuarioDao
     */
    public UsuarioDaoImpl getUsuarioDao() {
        return usuarioDao;
    }

    /**
     * @return the alunoCursoDao
     */
    public AlunoCursoDaoImpl getAlunoCursoDao() {
        return alunoCursoDao;
    }

    /**
     * @return the descontoDao
     */
    public DescontoDaoImpl getDescontoDao() {
        return descontoDao;
    }

    /**
     * @return the permissaoDao
     */
    public PermissaoDaoImpl getPermissaoDao() {
        return permissaoDao;
    }

    /**
     * @return the situacaoDoAlunoNaTurmaDao
     */
    public SituacaoDoAlunoNaTurmaDaoImpl getSituacaoDoAlunoNaTurmaDao() {
        return situacaoDoAlunoNaTurmaDao;
    }

}
