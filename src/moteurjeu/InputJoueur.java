package moteurjeu;


import graphique.StdDraw;

public class InputJoueur extends Input {
	
	private boolean accepteInput;
	private String actionPrevue;


	public InputJoueur(GererPartie jeu, Plongeur p) {
		super(jeu, p);
		this.accepteInput=false;
		this.actionPrevue=null;
	}

	
	
	@Override
	public String prochaineAction() {
		this.accepteInput=true;
		while(this.actionPrevue==null) {
	       StdDraw.pause(20); //CHECK
	       if(StdDraw.hasNextKeyTyped()) {
	    	   		this.analyserTouchePressee();
	       }
		}
		String actionTodo = this.actionPrevue;
		this.actionPrevue=null;
		return actionTodo;
	}

	
	public void analyserTouchePressee(){
		// TODO Auto-generated method stub
		char touchePressee = StdDraw.nextKeyTyped();
		
		char keyCodeToucheHaut = 'z';
		char keyCodeToucheBas = 's';
		char keyCodeToucheBarreEspace = ' ';
		if(touchePressee==keyCodeToucheHaut) {
			this.actionPrevue = Input.actionMonter;
			this.accepteInput=false;
		}
		if(touchePressee==keyCodeToucheBas) {
			this.actionPrevue = Input.actionDescendre;
			this.accepteInput=false;
		}
		if(touchePressee==keyCodeToucheBarreEspace) {
			this.actionPrevue = Input.actionRecuperer;
			this.accepteInput=false;
		}
		
		System.out.println(touchePressee);
		
	}

	

}
