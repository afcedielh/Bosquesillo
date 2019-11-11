package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Laberinto {
	private int id;
	private Actor[][] actor;
	private List<Coordenada> destino;

	public Laberinto(int id,  Actor[][] actor, List<Coordenada> destino) {
		super();
		this.id = id;
		this.actor = actor;
		this.destino = destino;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  Actor[][] getActor() {
		return actor;
	}

	public void setActor( Actor[][] actor) {
		this.actor = actor;
	}

	public List<Coordenada> getDestino() {
		return destino;
	}

	public void setDestino(List<Coordenada> destino) {
		this.destino = destino;
	}

	public void AgregarDestino(Coordenada punto) {
		if(this.destino == null) {
			this.destino = new ArrayList<Coordenada>();			
		}
		this.destino.add(punto);
	}	

	public void ConfigurarTablero(int monstruos) throws Exception {		
		if (this.actor == null) {
			throw new Exception("No se ha generado una matríz aún.");
		} else {
			Random r = new Random();
			int obstaculos[] = new int[6];
			for (int i = 0; i < obstaculos.length; i++) {
				if(i<3) {
					obstaculos[i] =  r.nextInt((int) ((Math.ceil((double)monstruos/2))-obstaculos[0]));					
					if(i == 2)
						obstaculos[i] = ((int)(Math.ceil((double)monstruos/2))-obstaculos[0]-obstaculos[1]);
				}else {
					obstaculos[i] =  r.nextInt((monstruos/2)-obstaculos[3]);
					if(i == 5)
						obstaculos[i] = (monstruos/2)-obstaculos[3]-obstaculos[4];
				}
				System.out.println(obstaculos[i]);
			}
			int x,y;
			for	(int i = 0; i < obstaculos.length; i++) {					
				for	(int j = 0; j < obstaculos[i]; j++) {
					Boolean bandera = false;
					while(!bandera) {
						x = r.nextInt(this.actor.length);
						y = r.nextInt(this.actor[0].length);
						if (this.actor[x][y]== null) {
							bandera = true;
							switch (i) {
							case 0:
								this.actor[x][y] = new Actor(Obstaculo.Muro,null,null);
								break;
							case 1:
								this.actor[x][y] = new Actor(Obstaculo.Tormentoso,null,null);
								break;
							case 2: 
								this.actor[x][y] = new Actor(Obstaculo.Letal,null,null);
								break;
							case 3: 					
								this.actor[x][y] = new Actor(Obstaculo.Angelito,null,null);
								break;
							case 4: 					
								this.actor[x][y] = new Actor(Obstaculo.Corazon,null,null);
								break;
							case 5: 					
								this.actor[x][y] = new Actor(Obstaculo.Escudo,null,null);
								break;
							default:
								break;
							}
						}
					}
				}
			}
			for (int i = 0; i < actor.length; i++) 	  
			{
				System.out.println("");
				for (int j = 0; j < actor[i].length; j++) 
				{
					if(actor[i][j] != null)
						System.out.print("O ");
					else
						System.out.print("x ");
				}
			}
		}
	}
}
