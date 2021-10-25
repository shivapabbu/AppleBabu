package optum;

import java.awt.Rectangle;

public class Projectile {

	private int x, y, speedX;
	private boolean visible;
	
	private Rectangle r;
	
	public Projectile(int startX, int startY){
		x = startX;
		y = startY;
		speedX = 7;
		visible = true;
		
		r = new Rectangle(0, 0, 0, 0);
	}
	
	public void update(){
		x += speedX;
		r.setBounds(x, y, 10, 5);
		if (x > 800){
			visible = false;
			r = null;
		}
		if (x < 800){
			checkCollision();
		}
	}

	private void checkCollision() {
		if(r.intersects(OptumHero.hb.r)){
			visible = false;
		
			if (OptumHero.hb.health > 0) {
				OptumHero.hb.health -= 1;
			}
			if (OptumHero.hb.health == 0) {
				OptumHero.hb.setCenterX(-100);
				OptumHero.score += 5;

			}

		}
		
		if (r.intersects(OptumHero.hb2.r)){
			visible = false;

			if (OptumHero.hb2.health > 0) {
				OptumHero.hb2.health -= 1;
			}
			if (OptumHero.hb2.health == 0) {
				OptumHero.hb2.setCenterX(-100);
				OptumHero.score += 5;

			}

		}
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
}
