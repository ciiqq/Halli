package fi.softala.service;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;
import fi.softala.dao.KoulutusDAOImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class KoulutustilaisuusServiceImpl implements KoulutustilaisuusService {
	
	final String AVAINSANA_EROTIN = ",";
	
	@Inject
	private KoulutusDAO koulutusDao;

	public void tallennaUusiKoulutustilaisuus(Koulutustilaisuus koulutustilaisuus) {
		koulutustilaisuus.setNakyvyys(false);
		koulutusDao.tallennaKoulussuunnitelma(koulutustilaisuus);
		koulutusDao.tallennaKoulutuksenKouluttaja(koulutustilaisuus.getId(), koulutustilaisuus.getKouluttajat().get(0).getOpiskelijanro());

		pilkoJaTallennaKoulutuksenAvainsanat(koulutustilaisuus);
	}
	  
	/**
	 * Olettaa, että koulutustilausuus.avainsanat ArrayListan indeksissä 0 on
	 * yhdessä Stringissä pilkulla eroteltuna kaikki UI:ssa syötetyt avainsanat.
	 * @param koulutustilaisuus Koulutustilaisuus
	 */
	private void pilkoJaTallennaKoulutuksenAvainsanat(Koulutustilaisuus koulutustilaisuus) {
		if (koulutustilaisuus.getId() == 0) {
			return;			
		}
		
		List<String> sanat = koulutustilaisuus.getAvainsanat();
		if (!sanat.isEmpty() && sanat.size() == 1) {
			
			String[] splitatutSanat = sanat.get(0).split(AVAINSANA_EROTIN);
			sanat.clear();
			for (String s : splitatutSanat) {
				
				s = s.trim();
				if (!StringUtils.isEmpty(s)) {
					sanat.add(s);					
				}		
			}
		}
		
		for (String s : sanat) {
			koulutusDao.tallennaAvainsana(s, koulutustilaisuus.getId());
			
		}
		
		
		
		
	}

	public void setKoulutusDao(KoulutusDAOImpl koulutusDao) {
		this.koulutusDao = koulutusDao;
	}

}
