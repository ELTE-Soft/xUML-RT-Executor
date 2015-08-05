/**
 */
package com.incquerylabs.uml.ralf.reducedAlfLanguage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relational Operator</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.incquerylabs.uml.ralf.reducedAlfLanguage.ReducedAlfLanguagePackage#getRelationalOperator()
 * @model
 * @generated
 */
public enum RelationalOperator implements Enumerator
{
  /**
   * The '<em><b>Greater Than</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_THAN_VALUE
   * @generated
   * @ordered
   */
  GREATER_THAN(0, "greaterThan", ">"),

  /**
   * The '<em><b>Lesser Than</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LESSER_THAN_VALUE
   * @generated
   * @ordered
   */
  LESSER_THAN(1, "lesserThan", "<"),

  /**
   * The '<em><b>Greater Or Equals</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #GREATER_OR_EQUALS_VALUE
   * @generated
   * @ordered
   */
  GREATER_OR_EQUALS(2, "greaterOrEquals", ">="),

  /**
   * The '<em><b>Lesser Or Equals</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #LESSER_OR_EQUALS_VALUE
   * @generated
   * @ordered
   */
  LESSER_OR_EQUALS(3, "lesserOrEquals", "<=");

  /**
   * The '<em><b>Greater Than</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Greater Than</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER_THAN
   * @model name="greaterThan" literal=">"
   * @generated
   * @ordered
   */
  public static final int GREATER_THAN_VALUE = 0;

  /**
   * The '<em><b>Lesser Than</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Lesser Than</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LESSER_THAN
   * @model name="lesserThan" literal="<"
   * @generated
   * @ordered
   */
  public static final int LESSER_THAN_VALUE = 1;

  /**
   * The '<em><b>Greater Or Equals</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Greater Or Equals</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #GREATER_OR_EQUALS
   * @model name="greaterOrEquals" literal=">="
   * @generated
   * @ordered
   */
  public static final int GREATER_OR_EQUALS_VALUE = 2;

  /**
   * The '<em><b>Lesser Or Equals</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>Lesser Or Equals</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #LESSER_OR_EQUALS
   * @model name="lesserOrEquals" literal="<="
   * @generated
   * @ordered
   */
  public static final int LESSER_OR_EQUALS_VALUE = 3;

  /**
   * An array of all the '<em><b>Relational Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final RelationalOperator[] VALUES_ARRAY =
    new RelationalOperator[]
    {
      GREATER_THAN,
      LESSER_THAN,
      GREATER_OR_EQUALS,
      LESSER_OR_EQUALS,
    };

  /**
   * A public read-only list of all the '<em><b>Relational Operator</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<RelationalOperator> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RelationalOperator get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelationalOperator result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RelationalOperator getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      RelationalOperator result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relational Operator</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RelationalOperator get(int value)
  {
    switch (value)
    {
      case GREATER_THAN_VALUE: return GREATER_THAN;
      case LESSER_THAN_VALUE: return LESSER_THAN;
      case GREATER_OR_EQUALS_VALUE: return GREATER_OR_EQUALS;
      case LESSER_OR_EQUALS_VALUE: return LESSER_OR_EQUALS;
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
  private RelationalOperator(int value, String name, String literal)
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
  
} //RelationalOperator
