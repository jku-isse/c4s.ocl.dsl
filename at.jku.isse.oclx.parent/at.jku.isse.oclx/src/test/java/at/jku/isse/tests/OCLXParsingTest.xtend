/*
 * generated by Xtext 2.34.0
 */
package at.jku.isse.tests

import at.jku.isse.oclx.Model
import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import at.jku.isse.oclx.OclxPackage
import at.jku.isse.validation.OCLXValidator

@ExtendWith(InjectionExtension)
@InjectWith(OCLXInjectorProvider)

class OCLXParsingTest {
	@Inject
	ParseHelper<Model> parseHelper
	
	@Inject ValidationTestHelper validationTestHelper
	
	
	@Test
	def void loadKnownBasicContext() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "ignored"
				context: String
				expression: self.isDefined() 
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertNoErrors(result);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
		@Test
	def void loadKnownContext() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "ignored"
				context: DemoIssue
				expression: self.isDefined() 
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertNoErrors(result);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test
	def void loadUnknownContext() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "ignored"
				context: noSuchType
				expression: self.isDefined() 
			}
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.CONSTRAINT, 
			OCLXValidator.UNKNOWN_TYPE
		);
	}
	
	@Test
	def void loadSyntacticCorrectSmallModel() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing a better way to provide a description
				to a rule"
				is overrulable: false
				context: DemoIssue
				/* some comment here */
				expression: not(self->FORALL(x : <test/type/decl> | x.isDefined() ) )
			}
		''')
		Assertions.assertNotNull(result)
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test
	def void loadDuplicateVarDeclaration() {
		val result = parseHelper.parse('''
rule AnotherRule {
	context: nosu
	expression: self.downstream->FORALL(x | (x.isDefined() 
												and 
											self->SELECT( x | x.size() > 0)
											) 
										)  
}
		''')
		Assertions.assertNotNull(result)
		
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.ITERATOR_VAR_DECLARATION, 
			OCLXValidator.DUPLICATE_VAR_NAME
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test 
	def void loadDuplicateVarDeclaration2() {
		val result = parseHelper.parse(	'''rule TestRule2 {
	    description: "just some test"
	    is overrulable: false
	    context: DemoIssue
	    expression: ( 
	            self.downstream 
	                ->EXISTS(req | req.bugs.size() > 0)
	        and 
	            self->isDefined()
	        and self.downstream->FORALL( req |  req.isEmpty() )  )
	
	}''')
		Assertions.assertNotNull(result)
		
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.ITERATOR_VAR_DECLARATION, 
			OCLXValidator.DUPLICATE_VAR_NAME
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	

	
	@Test
	def void loadKnownPropertyUsage() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "ignored"
				context: DemoIssue
				expression: self.requirements.size() > 1
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertNoErrors(result);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test
	def void testFindUnknownTypeDeclaration() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: DemoIssue
				expression: not(self.requirements->FORALL(x : <test/type/decl> | x.isDefined() ) )
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.TYPE_EXP, 
			OCLXValidator.UNKNOWN_TYPE
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test
	def void testFindKnownTypeDeclaration() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: DemoIssue
				expression: not(self.requirements->FORALL(x : <root/types/DemoIssue> | x.parent <> null ) )
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertNoErrors(result);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test
	def void testUpcastVariable() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: artifact
				expression: self.asType(<root/types/DemoIssue>).requirements.size() > 0 
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertNoErrors(result);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
	@Test
	def void testDowncastVariable() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: DemoIssue
				expression: self.asType(<root/types/artifact>).requirements.size() > 0 
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.PROPERTY_ACCESS_EXP, 
			OCLXValidator.UNKNOWN_PROPERTY
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
		@Test
	def void testTemporalNestedReturnType() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: DemoIssue
				expression: next(self.requirements) 
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.EXP, 
			OCLXValidator.INCOMPATIBLE_RETURN_TYPE
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
			@Test
	def void testTriggeredTemporalNestedReturnType() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: DemoIssue
				expression: everytime(self.requirements) then(self.requirements.size() > 0)
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertError(result, 
			OclxPackage.Literals.EXP, 
			OCLXValidator.INCOMPATIBLE_RETURN_TYPE
		);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
	
			@Test
	def void testTriggeredTemporalNestedReturnTypeSuccess() {
		val result = parseHelper.parse('''
			rule TestRule {
				description: "testing"
				context: DemoIssue
				expression: asLongAs(self.requirements.isEmpty()) ensureThat(self.requirements.size() > 0)
			}
		''')
		Assertions.assertNotNull(result)
		validationTestHelper.assertNoErrors(result);
		val errors = result.eResource.errors
		Assertions.assertTrue(errors.isEmpty, '''Unexpected errors: «errors.join(", \r\n")»''')
	}
}
