/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assignment Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getAssignmentOperator()
 * @model
 * @generated
 */
public enum AssignmentOperator implements Enumerator
{
  /**
   * The '<em><b>Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #ASSIGN_VALUE
   * @generated
   * @ordered
   */
  ASSIGN(0, "assign", "="),

  /**
   * The '<em><b>Increment Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INCREMENT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  INCREMENT_ASSIGN(1, "incrementAssign", "+="),

  /**
   * The '<em><b>Decrement Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DECREMENT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  DECREMENT_ASSIGN(2, "decrementAssign", "-="),

  /**
   * The '<em><b>Multiply Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLY_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  MULTIPLY_ASSIGN(3, "multiplyAssign", "*="),

  /**
   * The '<em><b>Division Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #DIVISION_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  DIVISION_ASSIGN(4, "divisionAssign", "/="),

  /**
   * The '<em><b>Modulo Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MODULO_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  MODULO_ASSIGN(5, "moduloAssign", "%="),

  /**
   * The '<em><b>And Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #AND_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  AND_ASSIGN(6, "andAssign", "&="),

  /**
   * The '<em><b>Or Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OR_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  OR_ASSIGN(7, "orAssign", "|="),

  /**
   * The '<em><b>Xor Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #XOR_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  XOR_ASSIGN(8, "xorAssign", "^="),

  /**
   * The '<em><b>Left Shift Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LEFT_SHIFT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  LEFT_SHIFT_ASSIGN(9, "leftShiftAssign", "<<="),

  /**
   * The '<em><b>Right Shift Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RIGHT_SHIFT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  RIGHT_SHIFT_ASSIGN(10, "rightShiftAssign", ">>="),

  /**
   * The '<em><b>Triple Shift Assign</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #TRIPLE_SHIFT_ASSIGN_VALUE
   * @generated
   * @ordered
   */
  TRIPLE_SHIFT_ASSIGN(11, "tripleShiftAssign", ">>>=");

  /**
   * The '<em><b>Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #ASSIGN
   * @model name="assign" literal="="
   * @generated
   * @ordered
   */
  public static final int ASSIGN_VALUE = 0;

  /**
   * The '<em><b>Increment Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Increment Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INCREMENT_ASSIGN
   * @model name="incrementAssign" literal="+="
   * @generated
   * @ordered
   */
  public static final int INCREMENT_ASSIGN_VALUE = 1;

  /**
   * The '<em><b>Decrement Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Decrement Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DECREMENT_ASSIGN
   * @model name="decrementAssign" literal="-="
   * @generated
   * @ordered
   */
  public static final int DECREMENT_ASSIGN_VALUE = 2;

  /**
   * The '<em><b>Multiply Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Multiply Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MULTIPLY_ASSIGN
   * @model name="multiplyAssign" literal="*="
   * @generated
   * @ordered
   */
  public static final int MULTIPLY_ASSIGN_VALUE = 3;

  /**
   * The '<em><b>Division Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Division Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #DIVISION_ASSIGN
   * @model name="divisionAssign" literal="/="
   * @generated
   * @ordered
   */
  public static final int DIVISION_ASSIGN_VALUE = 4;

  /**
   * The '<em><b>Modulo Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Modulo Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #MODULO_ASSIGN
   * @model name="moduloAssign" literal="%="
   * @generated
   * @ordered
   */
  public static final int MODULO_ASSIGN_VALUE = 5;

  /**
   * The '<em><b>And Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>And Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #AND_ASSIGN
   * @model name="andAssign" literal="&="
   * @generated
   * @ordered
   */
  public static final int AND_ASSIGN_VALUE = 6;

  /**
   * The '<em><b>Or Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Or Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #OR_ASSIGN
   * @model name="orAssign" literal="|="
   * @generated
   * @ordered
   */
  public static final int OR_ASSIGN_VALUE = 7;

  /**
   * The '<em><b>Xor Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Xor Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #XOR_ASSIGN
   * @model name="xorAssign" literal="^="
   * @generated
   * @ordered
   */
  public static final int XOR_ASSIGN_VALUE = 8;

  /**
   * The '<em><b>Left Shift Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Left Shift Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LEFT_SHIFT_ASSIGN
   * @model name="leftShiftAssign" literal="<<="
   * @generated
   * @ordered
   */
  public static final int LEFT_SHIFT_ASSIGN_VALUE = 9;

  /**
   * The '<em><b>Right Shift Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Right Shift Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #RIGHT_SHIFT_ASSIGN
   * @model name="rightShiftAssign" literal=">>="
   * @generated
   * @ordered
   */
  public static final int RIGHT_SHIFT_ASSIGN_VALUE = 10;

  /**
   * The '<em><b>Triple Shift Assign</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Triple Shift Assign</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #TRIPLE_SHIFT_ASSIGN
   * @model name="tripleShiftAssign" literal=">>>="
   * @generated
   * @ordered
   */
  public static final int TRIPLE_SHIFT_ASSIGN_VALUE = 11;

  /**
   * An array of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final AssignmentOperator[] VALUES_ARRAY =
    new AssignmentOperator[]
    {
      ASSIGN,
      INCREMENT_ASSIGN,
      DECREMENT_ASSIGN,
      MULTIPLY_ASSIGN,
      DIVISION_ASSIGN,
      MODULO_ASSIGN,
      AND_ASSIGN,
      OR_ASSIGN,
      XOR_ASSIGN,
      LEFT_SHIFT_ASSIGN,
      RIGHT_SHIFT_ASSIGN,
      TRIPLE_SHIFT_ASSIGN,
    };

  /**
   * A public read-only list of all the '<em><b>Assignment Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<AssignmentOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AssignmentOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssignmentOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AssignmentOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      AssignmentOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Assignment Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static AssignmentOperator get(int value)
  {
    switch (value)
    {
      case ASSIGN_VALUE: return ASSIGN;
      case INCREMENT_ASSIGN_VALUE: return INCREMENT_ASSIGN;
      case DECREMENT_ASSIGN_VALUE: return DECREMENT_ASSIGN;
      case MULTIPLY_ASSIGN_VALUE: return MULTIPLY_ASSIGN;
      case DIVISION_ASSIGN_VALUE: return DIVISION_ASSIGN;
      case MODULO_ASSIGN_VALUE: return MODULO_ASSIGN;
      case AND_ASSIGN_VALUE: return AND_ASSIGN;
      case OR_ASSIGN_VALUE: return OR_ASSIGN;
      case XOR_ASSIGN_VALUE: return XOR_ASSIGN;
      case LEFT_SHIFT_ASSIGN_VALUE: return LEFT_SHIFT_ASSIGN;
      case RIGHT_SHIFT_ASSIGN_VALUE: return RIGHT_SHIFT_ASSIGN;
      case TRIPLE_SHIFT_ASSIGN_VALUE: return TRIPLE_SHIFT_ASSIGN;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private AssignmentOperator(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //AssignmentOperator
