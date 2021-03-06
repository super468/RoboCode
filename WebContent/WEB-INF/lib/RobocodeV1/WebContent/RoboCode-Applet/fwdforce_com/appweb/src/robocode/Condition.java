/*******************************************************************************
 * Copyright (c) 2001, 2007 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Mathew A. Nelson
 *     - Initial API and implementation
 *     Flemming N. Larsen
 *     - Code cleanup
 *     - Updated Javadoc
 *******************************************************************************/
package robocode;


import robocode.security.RobocodeSecurityManager;


/**
 * Condition is used to define custom  AdvancedRobot#waitFor waitFor} and
 * custom events for a {@link AdvancedRobot}. The code below is taken from the
 * sample robot named Target. See Target.java for details.
 * <pre>
 *   addCustomEvent(
 *       new Condition("triggerhit") {
 *           public boolean test() {
 *               return (getEnergy() <= trigger);
 *           };
 *       }
 *   );
 * </pre>
 * You should note that by extending Condition this way, you are actually
 * creating an inner class -- so if you distribute your robot, there will be
 * multiple class files.  (i.e. Target$1.class)
 *
 * @see AdvancedRobot#waitFor
 * @see AdvancedRobot#addCustomEvent
 * @see AdvancedRobot#removeCustomEvent
 * @see AdvancedRobot#onCustomEvent
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public abstract class Condition {

	/**
	 * The priority of this condition. Defaults to 80.
	 */
	public int priority = 80;

	/**
	 * The name of this condition.
	 */
	public String name;

	/**
	 * Creates a new, unnamed Condition with the default priority, which is 80.
	 */
	public Condition() {}

	/**
	 * Creates a new Condition with the specified name, and default priority,
	 * which is 80.
	 * 
	 * @param name the name for the new Condition
	 */
	public Condition(String name) {
		this.name = name;
	}

	/**
	 * Creates a new Condition with the specified name and priority.
	 * A condition priority is a value from 0 - 99. The higher value, the
	 * higher priority. The default priority is 80.
     *
	 * @param name the name for the new condition
	 * @param priority the priority of the new condition
	 */
	public Condition(String name, int priority) {
		this.name = name;
		if (priority < 0) {
			SecurityManager m = System.getSecurityManager();

			if (m instanceof RobocodeSecurityManager) {
				RobocodeSecurityManager rsm = (RobocodeSecurityManager) m;

				rsm.threadOut("SYSTEM: Priority must be between 0 and 99.");
				rsm.threadOut("SYSTEM: Priority for condition " + name + " will be 0.");
			}
			priority = 0;
		} else if (priority > 99) {
			SecurityManager m = System.getSecurityManager();

			if (m instanceof RobocodeSecurityManager) {
				RobocodeSecurityManager rsm = (RobocodeSecurityManager) m;

				rsm.threadOut("SYSTEM: Priority must be between 0 and 99.");
				rsm.threadOut("SYSTEM: Priority for condition " + name + " will be 99.");
			}
			priority = 99;
		}
		this.priority = priority;
	}

	/**
	 * Returns the name of this condition.
	 * 
	 * @return the name of this condition
	 */
	public String getName() {
		return (name != null) ? name : getClass().getName();
	}

	/**
	 * Returns the priority of this condition.
	 * A condition priority is a value from 0 - 99. The higher value, the
	 * higher priority. The default priority is 80.
	 *
	 * @return the priority of this condition
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * Sets the name of this condition.
	 *
	 * @param newName the new name of this condition
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Sets the priority of this condition.
	 * A condition priority is a value from 0 - 99. The higher value, the
	 * higher priority. The default priority is 80.
	 *
	 * @param newPriority the new priority of this condition.
	 */
	public void setPriority(int newPriority) {
		priority = newPriority;
	}

	/**
	 * Overriding the test() method is the point of a Condition.
	 * The game will call your test() function, and take action if it returns
	 * {@code true}. This is valid for both {@link AdvancedRobot#waitFor} and
	 * {@link AdvancedRobot#addCustomEvent}.
	 * <p>
	 * You may not take any actions inside of test().
	 *
	 * @return {@code true} if the condition has been met, {@code false}
	 *    otherwise.
	 */
	public abstract boolean test();
}
