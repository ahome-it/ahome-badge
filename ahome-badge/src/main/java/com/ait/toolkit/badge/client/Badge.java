/*
 Copyright (c) 2014 Ahomé Innovation Technologies. All rights reserved.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package com.ait.toolkit.badge.client;

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.user.client.ui.Widget;

public class Badge extends JsObject {

	private static final BadgeResource resources = (BadgeResource) GWT.create(BadgeResource.class);

	static {
		load();
	}

	public Badge(String targetId) {
		jsObj = createPeer(targetId);
		setTheme(BadgeTheme.IOS);
		setPosition(BadgePosition.TOP_LEFT);
		setContent(0);
	}

	public Badge(Element target) {
		this(target.getId());
	}

	public Badge(Widget target) {
		this(target.getElement());
	}

	/**
	 * Returns the current content that is set for the badge.
	 */
	public native String getContent()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			return peer.getContent();
		}
		return null;

	}-*/;

	/**
	 * Set the content of your badge. Your content can be a `Number` or a `String` e.g. `.setContent(2)`. Increase or decrease your current badge number by passing a `+` or `-`
	 * prefixed number in a string e.g. `.setContent('+7')`. Chainable.
	 */
	public native Badge setContent(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.setContent(value);
		}
		return this;
	}-*/;

	/**
	 * Set the content of your badge. Your content can be a `Number` or a `String` e.g. `.setContent(2)`. Increase or decrease your current badge number by passing a `+` or `-`
	 * prefixed number in a string e.g. `.setContent('+7')`. Chainable.
	 */
	public native Badge setContent(int value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.setContent(value);
		}
		return this;
	}-*/;

	/**
	 * Set the content of your badge. Your content can be a `Number` or a `String` e.g. `.setContent(2)`. Increase or decrease your current badge number by passing a `+` or `-`
	 * prefixed number in a string e.g. `.setContent('+7')`. Chainable.
	 */
	public Badge setPosition(BadgePosition position) {
		return _setPosition(position.name().toLowerCase().replace("_", "-"));
	}

	/**
	 * Set the theme of your badge. Default themes are: `'red'`, `'blue'`, `'green'`, `'grey'` and `'ios'`. Themes can be configured in the `iosbadge.scss` file and then built with
	 * the included build tool.
	 */
	public Badge setTheme(BadgeTheme theme) {
		return _setTheme(theme.name().toLowerCase());
	}

	/**
	 * Set the size of your badge. Sizes can be configured in the 'iosbadge.scss' file and then built with the included build tool. Available default sizes are: `20`, `22`, `24`,
	 * `26`, `28`, `30`, `32`, `34` and `36`
	 */
	public native Badge setSize(int value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.setSize(value);
		}
		return this;
	}-*/;

	/**
	 * Decrease the current number in your badge.
	 */
	public native Badge decreaseBy(int value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.decreaseBy(value);
		}
		return this;
	}-*/;

	/**
	 * Decrease the current number in your badge.
	 */
	public native Badge increaseBy(int value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.increaseBy(value);
		}
		return this;
	}-*/;

	/**
	 * Hide your badge element.
	 */
	public native Badge hide()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.hide();
		}
		return this;
	}-*/;

	/**
	 * Show your badge element.
	 */
	public native Badge show()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.show();
		}
		return this;
	}-*/;

	private native Badge _setPosition(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.setPosition(value);
		}
		return this;
	}-*/;

	private native Badge _setTheme(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		if (peer != null) {
			peer.setTheme(value);
		}
		return this;
	}-*/;

	private static void load() {
		StyleInjector.inject(resources.css().getText());
		ScriptInjector.fromString(resources.jsMin().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
	}

	private native JavaScriptObject createPeer(String id)/*-{
		var el = $doc.getElementById(id);
		if (el) {
			return new $wnd.IOSBadge(el, {});
		}
		return null;

	}-*/;

}
