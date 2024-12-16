# SWITCH-TC-KOTLIN

The application tests threaded code generated by the editor of hierarchical state machines. The original scheme can be seen in the attached movie. It's another model of a switch (I hope it's the hundredth one, no less :-) ) affected by two events: __TURN__ and __RESET__. The first switches two states __ON__ and __OFF__, the second resets the state machine to the __OFF__ state regardless of what state it was in before.

# Precondition

The editor's Planner module was supplemented with a __Kotlin__ code generator, which automatically generates the __Switch_resetHelper.kt__ file with the class of the same name. A core has also been added to the application, which services the launch of threaded code and the impact of events on it. This is a set of several very simple classes: __EventWrapper__, which describes and keep an event, __QHsmHelper__ with the __IQHsmStateMachineHelper__ interface, which contains a container of threaded codes and ensures its execution under the influence of events, __ThreadedCodeExecutor__ - a class that ensures the launch of threaded code for a specific state and event.

# Code modification

The generated __Switch_resetHelper.kt__ file is a skeleton for the logical part of the application, namely the list and bodies of empty transfer functions that can and should be filled with some content. For example, with trace elements in the simplest case. Some functions may not be used and should be deleted or commented out.

# Description of the application

The application does not contain activity, so it is impossible to run it on a phone or tablet. Can run the unit test testSwitch(), which traces the state machine:

```
> Task :app:testDebugUnitTest
OFF
OFF: TURN
ON 
@RESET
OFF
OFF: TURN
ON 
ON : TURN
OFF
@RESET
OFF
BUILD SUCCESSFUL in 21s
23 actionable tasks: 6 executed, 17 up-to-date

Build Analyzer results available
9:42:09: Execution finished ':app:testDebugUnitTest --tests "com.widget.switchkttc.ExampleUnitTest.testSwitch"'.
```

## Movie

https://github.com/user-attachments/assets/99469514-b41a-459c-ae87-378377c08ddb

