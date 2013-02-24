import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Suite que roda todos os testes
 * @author Hernand
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ EmpregadoTest.class, EmprestimoTest.class,GerenteTest.class} )
public final class AllTestsSuite {}