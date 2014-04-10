package fi.softala.halli;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fi.softala.koulutuslistaus.KoulutuslistausTest;



@RunWith(Suite.class)
@SuiteClasses({	
	KoulutuslistausTest.class
	})
public class AllTests {
}
