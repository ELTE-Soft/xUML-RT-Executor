package hu.eltesoft.modelexecution.ide.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * A project nature for executable model projects. Installs a builder on
 * configuration and enables a custom property page for the project.
 */
public class ExecutableModelNature implements IProjectNature {

	private IProject project;
	public static final String NATURE_ID = "hu.eltesoft.modelexecution.natures.executableModelNature";

	@Override
	public void configure() throws CoreException {
		registerModelBuilder();
	}

	@Override
	public void deconfigure() throws CoreException {
		removeModelBuilder();
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	private void registerModelBuilder() throws CoreException {
		if (hasModelBuilder()) {
			// already enabled
			return;
		}

		// add builder to project properties
		IProjectDescription description = project.getDescription();
		ICommand buildCommand = description.newCommand();
		buildCommand.setBuilderName(ModelBuilder.BUILDER_ID);

		List<ICommand> commands = new ArrayList<ICommand>();
		commands.addAll(Arrays.asList(description.getBuildSpec()));
		commands.add(buildCommand);

		description
				.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
		project.setDescription(description, null);
	}

	private boolean hasModelBuilder() throws CoreException {
		for (ICommand buildSpec : project.getDescription().getBuildSpec()) {
			if (ModelBuilder.BUILDER_ID.equals(buildSpec.getBuilderName()))
				return true;
		}
		return false;
	}

	private void removeModelBuilder() throws CoreException {
		LinkedList<ICommand> newBuildSpec = new LinkedList<>();
		for (ICommand builder : project.getDescription().getBuildSpec()) {
			if (!ModelBuilder.BUILDER_ID.equals(builder.getBuilderName()))
				newBuildSpec.add(builder);
		}
		project.getDescription().setBuildSpec(
				newBuildSpec.toArray(new ICommand[newBuildSpec.size()]));
	}

}
