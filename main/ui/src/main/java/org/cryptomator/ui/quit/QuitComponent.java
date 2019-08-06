/*******************************************************************************
 * Copyright (c) 2017 Skymatic UG (haftungsbeschränkt).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the accompanying LICENSE file.
 *******************************************************************************/
package org.cryptomator.ui.quit;

import dagger.BindsInstance;
import dagger.Lazy;
import dagger.Subcomponent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.cryptomator.ui.common.FxmlFile;
import org.cryptomator.ui.common.FxmlScene;

import java.awt.desktop.QuitResponse;

@QuitScoped
@Subcomponent(modules = {QuitModule.class})
public interface QuitComponent {

	@QuitWindow
	Stage window();

	@FxmlScene(FxmlFile.QUIT)
	Lazy<Scene> scene();

	default void showQuitWindow() {
		Stage stage = window();
		stage.setScene(scene().get());
		stage.show();
		stage.requestFocus();
	}

	@Subcomponent.Builder
	interface Builder {

		@BindsInstance
		Builder quitResponse(QuitResponse response);

		QuitComponent build();
	}

}
