package at.jku.isse.ide.assistance;

import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import at.jku.isse.oclx.Constraint;
import at.jku.isse.oclx.MethodExp;
import at.jku.isse.oclx.NavigationOperator;
import at.jku.isse.oclx.PropertyAccessExp;
import at.jku.isse.oclx.SelfExp;
import at.jku.isse.oclx.VarReference;

public class OclxASTUtils {
	
	public static Optional<Constraint> getRootConstraint(EObject object) {
		if (object == null)
			return Optional.empty();
		if (object instanceof Constraint)
			return Optional.of((Constraint)object);
		if (object.eContainer() != null)
			return getRootConstraint(object.eContainer());
		return Optional.empty();
	}
	
	public static NavigationOperator findPrecedingOperatorFor(MethodExp propExp) {
		EList<NavigationOperator> navOps;
		EList<MethodExp> methods;
		if (propExp.eContainer() instanceof SelfExp) {
			SelfExp selfExp = (SelfExp) propExp.eContainer();
			navOps = selfExp.getNav();
			methods = selfExp.getMethods();
		} else if (propExp.eContainer() instanceof VarReference) {
			VarReference varRef = (VarReference) propExp.eContainer();
			navOps = varRef.getNav();
			methods = varRef.getMethods();
		} else {
			return null;
		}
		int methodPos = 0;
		for (MethodExp mExp : methods) {
			if (mExp.equals(propExp)) {
				//found the pos
				return navOps.get(methodPos);
			}
			methodPos++;
		}
		return null; // should not happen
	}
	
	public static Optional<NavigationOperator> findSuccessorNavigationOperator(EObject selfVarOrPropAccess) {
		if (selfVarOrPropAccess instanceof PropertyAccessExp) {
			return findSuccessorNavigationOperatorForPropertyAccess((PropertyAccessExp) selfVarOrPropAccess);
		} else if (selfVarOrPropAccess instanceof SelfExp) {
			SelfExp selfExp = (SelfExp)selfVarOrPropAccess;
			if (selfExp.getNav().size() > 0)
				return Optional.ofNullable(selfExp.getNav().get(0));
		} else if (selfVarOrPropAccess instanceof VarReference) {
			VarReference varRef = (VarReference) selfVarOrPropAccess;
			if (varRef.getNav().size() > 0)
				return Optional.ofNullable(varRef.getNav().get(0));
		}
		return Optional.empty();
	}
	
	private static Optional<NavigationOperator> findSuccessorNavigationOperatorForPropertyAccess(PropertyAccessExp propExp) {
		EList<NavigationOperator> navOps;
		EList<MethodExp> methods;
		if (propExp.eContainer() instanceof SelfExp) {
			SelfExp selfExp = (SelfExp) propExp.eContainer();
			navOps = selfExp.getNav();
			methods = selfExp.getMethods();
		} else if (propExp.eContainer() instanceof VarReference) {
			VarReference varRef = (VarReference) propExp.eContainer();
			navOps = varRef.getNav();
			methods = varRef.getMethods();
		} else {
			return Optional.empty();
		}
		int methodPos = 0;
		for (MethodExp mExp : methods) {
			if (mExp.equals(propExp)) {
				//found the pos, its the next one, check if it exists
				if (navOps.size() >= methodPos+2 ) {
					return Optional.ofNullable(navOps.get(methodPos+1));
				}
			}
			methodPos++;
		}
		return Optional.empty(); // should not happen
	}
}
