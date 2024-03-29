package com.github.marcoral.versatia.core.impl.apiimpl.modules;

import java.util.function.BiConsumer;

import com.github.marcoral.versatia.core.api.configuration.VersatiaConfigurationProcessor;
import com.github.marcoral.versatia.core.api.modules.VersatiaModule;
import com.github.marcoral.versatia.core.api.modules.VersatiaModuleInitializer;
import com.github.marcoral.versatia.core.api.modules.commands.CommandPriority;
import com.github.marcoral.versatia.core.api.modules.commands.VersatiaCommand;
import com.github.marcoral.versatia.core.api.modules.commands.VersatiaCommandFamilyBuilder;
import com.github.marcoral.versatia.core.api.modules.commands.VersatiaGenericCommand;
import com.github.marcoral.versatia.core.api.modules.commands.VersatiaPlayerCommand;
import com.github.marcoral.versatia.core.api.modules.commands.VersatiaPlayerCommandFamilyBuilder;
import com.github.marcoral.versatia.core.api.modules.loggers.LoggingPriority;
import com.github.marcoral.versatia.core.api.modules.loggers.VersatiaLogger;
import com.github.marcoral.versatia.core.api.modules.submodules.VersatiaSubmodule;
import com.github.marcoral.versatia.core.api.tools.modules.VersatiaSubmoduleHandlerProvider;

public class VersatiaModuleInitializerImpl implements VersatiaModuleInitializer {
    private VersatiaModule underlyingModule;

    public VersatiaModuleInitializerImpl(VersatiaModule underlyingModule) {
        this.underlyingModule = underlyingModule;
    }

    @Override
	public void addSubmodule(VersatiaSubmodule submodule) {
		underlyingModule.addSubmodule(submodule);
	}

	@Override
	public <T extends VersatiaSubmodule> T addServicedSubmodule(Class<? extends VersatiaSubmoduleHandlerProvider> handler, boolean hardDepend) {
		return underlyingModule.addServicedSubmodule(handler, hardDepend);	
	}

    @Override
	public void groupSubmodules(String groupKey, String... submodulesNames) {
		underlyingModule.groupSubmodules(groupKey, submodulesNames);
	}

    @Override
	public void registerGenericCommand(VersatiaGenericCommand command) {
		underlyingModule.registerGenericCommand(command);
	}

    @Override
	public void registerPlayerOnlyCommand(VersatiaPlayerCommand command) {
		underlyingModule.registerPlayerOnlyCommand(command);
	}

    @Override
	public void registerGenericCommand(VersatiaGenericCommand command, CommandPriority priority) {
		underlyingModule.registerGenericCommand(command, priority);
	}

    @Override
	public VersatiaCommandFamilyBuilder registerGenericCommandsFamily(VersatiaCommand descriptor) {
		return underlyingModule.registerGenericCommandsFamily(descriptor);
	}

    @Override
	public void registerPlayerOnlyCommand(VersatiaPlayerCommand command, CommandPriority priority) {
		underlyingModule.registerPlayerOnlyCommand(command, priority);
	}

    @Override
	public VersatiaCommandFamilyBuilder registerGenericCommandsFamily(VersatiaCommand descriptor, CommandPriority priority) {
		return underlyingModule.registerGenericCommandsFamily(descriptor, priority);
	}

    @Override
	public VersatiaPlayerCommandFamilyBuilder registerPlayerOnlyCommandsFamily(VersatiaCommand descriptor, CommandPriority priority) {
		return underlyingModule.registerPlayerOnlyCommandsFamily(descriptor, priority);
	}

	@Override
	public VersatiaPlayerCommandFamilyBuilder registerPlayerOnlyCommandsFamily(VersatiaCommand descriptor) {
		return underlyingModule.registerPlayerOnlyCommandsFamily(descriptor);
	}

	@Override
	public void overwriteConfiguration() {
		underlyingModule.overwriteConfiguration();
	}
	
	@Override
	public VersatiaLogger getLogger(String loggerKey) {
		return underlyingModule.getLogger(loggerKey);
	}
	
	@Override
	public void log(LoggingPriority priority, String messageTemplateName, Object... args) {
		underlyingModule.log(priority, messageTemplateName, args);	
	}
	
	@Override
	public VersatiaConfigurationProcessor getConfigProcessor(String path) {
		return underlyingModule.getConfigProcessor(path);
	}

	@Override
	public void setMessageTemplatesProcessor(BiConsumer<String, String> processor) {
		underlyingModule.setMessageTemplatesProcessor(processor);
	}

	@Override
	public VersatiaModule getUnderlyingModule() {
		return underlyingModule;
	}
}