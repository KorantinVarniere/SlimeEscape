	public void phaseDeCombat(Slime m1, Slime m2) {
		String[] choixInteraction = {"Attaquer" ,"Changer de Slime "};
		String[] attacks = {m1.getNormalAttackName(), m1.getMagicalAttackName(), "Se defendre","Retour"};
		//String[] items = new String[p.getItems().size() + 1];
		String sentence = "";

		Slime currentSlime = m1;
		/*
		for (int i = 0; i < p.getItems().size(); i++) {
			items[i] = p.getItems().get(i).toString();

		}

		items[items.length - 1] = "Retour";*/

		String[] slime = new String[p.getPlayerSlimes().size()+1];

		for (int i = 0; i < p.getPlayerSlimes().size(); i++) {
			slime[i] = p.getPlayerSlimes().get(i).toString();
		}

		slime[slime.length - 1] = "Retour";

		String[] msg = choixInteraction;

		System.out.println(display(currentSlime, m2, msg, sentence));


		while(currentSlime.isalive() && m2.isalive()) {
				System.out.println(display(currentSlime, m2, msg, sentence));

			sentence = "\n\n";
			Scanner scanner=new Scanner(System.in);
			char keyboard=' ';

			try{
				keyboard=scanner.nextLine().charAt(0);
			}catch(NoSuchElementException e){}


			if (this.etat == Etat.MENUCHOIX) {
				if(keyboard=='1') {

					msg = attacks;
					etat = Etat.COMBAT;
				}else if(keyboard=='2') {
					if (slime.length > 2) {
						msg = slime;
						etat = etat.CHANGESLIME;						
					}
				}

			}else if(keyboard == (msg.length + '0') ) {

				etat = Etat.MENUCHOIX;
				msg = choixInteraction;
			}else if(this.etat == Etat.COMBAT) {

				if (keyboard == '1') {
					int degat = currentSlime.getDamageNormalAttack() ;

					if (m2.isDefended()) {

						p.damage(m2, degat);
						m2.DenfendingOff();
					}else{
						p.damage(m2, degat);
					}

					sentence = "Le slime de " + currentSlime.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";
					etat = Etat.MENUCHOIX;
					msg = choixInteraction;


				}else if(keyboard == '2') {
					int degat = currentSlime.getDamageMagicalAttack() * (int)  (Types.compareTypes(currentSlime.getTypes(), m2.getTypes()).getCoeff());

					if (m2.isDefended()) {

						p.damage(m2, (int) (0.3 * degat));
						m2.DenfendingOff();
						sentence = "Le smile adverse se défend\nLe slime de " + currentSlime.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";

					}else {
						p.damage(m2, degat);

					}
					sentence = "Le slime de " + currentSlime.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";

				}else if(keyboard == '3') {
					currentSlime.DenfendingOn();
					sentence = "Votre Slime est prÃªt Ã  se dÃ©fendre";
				}

				if (keyboard == '1' || keyboard == '2' || keyboard == '3'  ) {
					botTurn = true;
				}

			}else if(this.etat == etat.CHANGESLIME) {
				currentSlime = p.getPlayerSlimes().get( ( int) ((keyboard - '0') -1)  ); 
			}

			sentence += "\n------------------------------------------------------------------------\n";
			
			if(currentSlime.isalive() && m2.isalive() && botTurn){
				
				Random rdm = new Random();
				int nb = rdm.nextInt(3);

				if(nb == 0) {
					
					int degat = m2.getDamageNormalAttack() ;

					if (currentSlime.isDefended()) {

						currentSlime.setHp(  currentSlime.getHp() - (int) (degat * 0.3)  );
						sentence += "Vous vous defendez et le slime ennemie de " + currentSlime.getTypes().toString() + " a infligé " + 0.3 * degat +" points de dÃ©gats avec " + m2.getNormalAttackName();
						m2.DenfendingOff();

					}else {
						
						currentSlime.setHp(  currentSlime.getHp() - degat  );
						sentence += "Le slime de " + m2.getTypes().toString() + " a infligé " + degat +" points de dÃ©gats avec " + m2.getNormalAttackName();

					}

				} if(nb == 1){
					int degat = m2.getDamageMagicalAttack() * (int)  (Types.compareTypes(m2.getTypes(), currentSlime.getTypes()).getCoeff());

					sentence += "Le monstre vous inflige des degats magiques avec " + m2.getDamageMagicalAttack();
				
					if (currentSlime.isDefended()) {

						p.damage(currentSlime, (int) (0.3 * degat));
						currentSlime.DenfendingOff();
						sentence += "Le smile adverse se défend\nLe slime de " + m2.getTypes().toString() + " a infligÃ© " + 0.3 * degat +" points de dÃ©gats";

					}else {
						p.damage(currentSlime, degat);

					}
					sentence += "Le slime de " + m2.getTypes().toString() + " a infligÃ© " + degat +" points de dÃ©gats";
					
				}else if (nb == 2){
				
					sentence += "Le slime ennemie est pret a se defendre";
					m2.DenfendingOn();

				}
			}

			if (!currentSlime.isalive()) {
				
				System.out.println("Votre slime est morts");
				
				p.getPlayerSlimes().remove(currentSlime);
				
				if (p.getPlayerSlimes().isEmpty()) {
					System.out.println("Vous n'avez plus de slime et vous avez perdu");
				}else {
					phaseDeCombat(p.getPlayerSlimes().get(0), m2);
				}
				
			}else if (!m2.isalive()){

				currentSlime.setXp(currentSlime.getXp()+1);
				currentSlime.evolve();
				System.out.println("Vous avez gagné");
			}

		}
	}