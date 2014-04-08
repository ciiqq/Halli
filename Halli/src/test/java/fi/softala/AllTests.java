package fi.softala;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fi.softala.koulutus.KoulutustilaisuusTest;

@RunWith(Suite.class)
@SuiteClasses({
	KoulutustilaisuusTest.class
	})
public class AllTests {
}