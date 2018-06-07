package de.diedavids.cuba.wizard.gui.components;

import com.haulmont.cuba.gui.components.Component;

public interface Wizard extends Component.OrderedContainer,
                Component.HasIcon, Component.HasCaption {
    String NAME = "wizard";

    enum WizardMode {
        HORIZONTAL,
        VERTICAL
    }

    void addStep(int index, WizardStep wizardStep);

    WizardStep getStep(String stepId);
}