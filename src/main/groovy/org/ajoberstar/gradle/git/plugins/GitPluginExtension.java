/* Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ajoberstar.gradle.git.plugins;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.gradle.api.Project;
import org.gradle.api.UncheckedIOException;

/**
 * Extension for Git properties.
 * @since 0.1.0
 */
public class GitPluginExtension {
	private Project project;
	
	/**
	 * Constructs the plugin extension.
	 * @param project the project to create
	 * the extension for
	 */
	public GitPluginExtension(Project project) {
		this.project = project;
	}
	
	/**
	 * Opens a {@code Git} instance for the
	 * repository path.
	 * @param repositoryPath the path to the
	 * repository
	 * @return a new Git instance
	 */
	public Git open(Object repositoryPath) {
		try {
			return Git.open(project.file(repositoryPath));
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
