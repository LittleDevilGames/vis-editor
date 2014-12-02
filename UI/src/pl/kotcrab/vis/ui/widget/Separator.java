/*******************************************************************************
 * Copyright 2014 Pawel Pastuszak
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package pl.kotcrab.vis.ui.widget;

import pl.kotcrab.vis.ui.VisUI;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Separator extends Widget {
	private SeparatorStyle style;

	public Separator () {
		style = VisUI.skin.get(SeparatorStyle.class);
	}
	
	public Separator (boolean useMenuStyle) {
		style = VisUI.skin.get(useMenuStyle ? "menu" : "default", SeparatorStyle.class);
	}
	
	public Separator (String styleName) {
		style = VisUI.skin.get(styleName, SeparatorStyle.class);
	}
	
	public Separator (SeparatorStyle style) {
		this.style = style;
	}

	@Override
	public float getPrefHeight () {
		return style.width;
	}

	@Override
	public void draw (Batch batch, float parentAlpha) {
		validate();
		style.background.draw(batch, getX(), getY(), getWidth(), getHeight());
	}

	static public class SeparatorStyle {
		public Drawable background;
		public int width;

		public SeparatorStyle () {
		}

		public SeparatorStyle (Drawable bg, int width) {
			this.background = bg;
			this.width = width;
		}
	}
}
