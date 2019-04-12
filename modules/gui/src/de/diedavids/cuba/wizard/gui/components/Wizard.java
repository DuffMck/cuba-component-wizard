package de.diedavids.cuba.wizard.gui.components;

import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.OrderedContainer;

import java.util.EventObject;
import java.util.function.Consumer;

public interface Wizard extends OrderedContainer,
                Component.HasIcon, Component.HasCaption {
    String NAME = "wizard";

    WizardStep addStep(int index, String name, WizardStepAware wizardStep);
    void addStep(int index, WizardStep wizardStep);

    WizardStep getStep(String stepId);

    void addWizardStepChangeListener(Consumer<WizardStepChangeEvent> eventConsumer);
    void removeWizardStepChangeListener(Consumer<WizardStepChangeEvent> eventConsumer);

    void removeStep(String name);

    class WizardStepChangeEvent extends EventObject {

        WizardStep prevStep;
        WizardStep step;

        public WizardStepChangeEvent(Wizard source, WizardStep prevStep, WizardStep step) {
            super(source);
            this.prevStep = prevStep;
            this.step = step;
        }

        @Override
        public Wizard getSource() {
            return (Wizard) super.getSource();
        }

        public WizardStep getPrevStep() {
            return prevStep;
        }

        public WizardStep getStep() {
            return step;
        }
    }

    @FunctionalInterface
    interface WizardStepChangeListener {
        void stepChanged(Wizard.WizardStepChangeEvent event);
    }


    void addWizardCancelClickListener(Consumer<WizardCancelClickEvent> eventConsumer);
    void removeWizardCancelClickListener(Consumer<WizardCancelClickEvent> eventConsumer);

    class WizardCancelClickEvent extends EventObject {
        public WizardCancelClickEvent(Wizard source) {
            super(source);
        }

        @Override
        public Wizard getSource() {
            return (Wizard) super.getSource();
        }
    }

    @FunctionalInterface
    interface WizardCancelClickListener {
        void cancelClicked(Wizard.WizardCancelClickEvent event);
    }




    void addWizardFinishClickListener(Consumer<WizardFinishClickEvent> eventConsumer);
    void removeWizardFinishClickListener(Consumer<WizardFinishClickEvent> eventConsumer);

    class WizardFinishClickEvent extends EventObject {
        public WizardFinishClickEvent(Wizard source) {
            super(source);
        }

        @Override
        public Wizard getSource() {
            return (Wizard) super.getSource();
        }
    }

    @FunctionalInterface
    interface WizardFinishClickListener {
        void finishClicked(Wizard.WizardFinishClickEvent event);
    }
}