package com.detivenc.spaceinvaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class SpaceInvaders extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture img_bullet;
	Texture img_alien;
	Player player;
	Alien[] aliens;
	int NumWidth_aliens = 11;
	int NumHeight_aliens = 5;
	int spacing_aliens = 40;
	int minX_aliens;
	int minY_aliens;
	int maxX_aliens;
	int maxY_aliens;
	int direction_aliens = 1;
	float speed_aliens = 100;
	//offset to move the aliens
	Vector2 offset_aliens;
	@Override
	public void create () {
		offset_aliens = Vector2.Zero;
		batch = new SpriteBatch();
		img = new Texture("Player.png");
		img_bullet = new Texture("bullet.png");
		img_alien = new Texture("Alien.png");
		player = new Player(img,img_bullet,Color.GREEN);
		aliens = new Alien[NumWidth_aliens*NumHeight_aliens];
		int i = 0;
		for(int y = 0;y<NumHeight_aliens;y++)
		{
			for(int x = 0;x<NumWidth_aliens;x++)
			{
				Vector2 position = new Vector2(x*spacing_aliens,y*spacing_aliens);
				position.x+= (float) Gdx.graphics.getWidth() /2;
				position.y+=Gdx.graphics.getHeight();
				position.x-=((float) NumWidth_aliens /2)*spacing_aliens;
				position.y-=(NumHeight_aliens)*spacing_aliens;
				aliens[i] = new Alien(position,img_alien,Color.GREEN);
				i++;
			}
		}
	}
	int amount_alive_aliens = 0;
	@Override
	public void render () {
		float deltaTime = Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.Draw(batch);
        for (Alien value : aliens) {
            if (value.Alive) {
                if (player.sprite_bullet.getBoundingRectangle().overlaps(value.sprite.getBoundingRectangle())) {
                    player.position_bullet.y = 10000;
                    value.Alive = false;
                    break;
                }
            }
        }
		minX_aliens = 10000;
		minY_aliens = 10000;
		maxX_aliens = 0;
		maxY_aliens = 0;
		amount_alive_aliens = 0;
		for(int i = 0;i<aliens.length;i++)
		{
			if(aliens[i].Alive)
			{
				int IndexX = i%NumWidth_aliens;
				int IndexY = i/NumWidth_aliens;
				if(IndexX>maxX_aliens)maxX_aliens = IndexX;
				if(IndexX<minX_aliens)minX_aliens = IndexX;
				if(IndexY>maxY_aliens)maxY_aliens = IndexY;
				if(IndexY<minY_aliens)minY_aliens = IndexY;
				amount_alive_aliens++;
			}
		}
		if(amount_alive_aliens  == 0)
		{
            for (Alien alien : aliens) {
                alien.Alive = true;
            }
			offset_aliens =  new Vector2(0,0);
			batch.end();
			speed_aliens = 100;
			return;
		}
		offset_aliens.x+=direction_aliens*deltaTime*speed_aliens;
		if(aliens[maxX_aliens].position.x>=Gdx.graphics.getWidth())
		{
			direction_aliens = -1;
			offset_aliens.y-=aliens[0].sprite.getHeight()*aliens[0].sprite.getScaleY()*0.25f;
			speed_aliens+=3;
		}
		if(aliens[minX_aliens].position.x<=0)
		{
			direction_aliens = 1;
			offset_aliens.y-=aliens[0].sprite.getHeight()*aliens[0].sprite.getScaleY()*0.25f;
			speed_aliens+=3;
		}
		if(aliens[minY_aliens].position.y<=0)
		{
			Gdx.app.exit();
		}
        for (Alien alien : aliens) {
            alien.position = new Vector2(alien.position_initial.x + offset_aliens.x, alien.position_initial.y + offset_aliens.y);
            if (alien.Alive) {
                alien.Draw(batch);
                if (alien.sprite.getBoundingRectangle().overlaps(player.sprite.getBoundingRectangle())) {
                    Gdx.app.exit();
                }
            }
        }

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
