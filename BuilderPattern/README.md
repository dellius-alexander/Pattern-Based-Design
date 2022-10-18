# Builder Design Pattern

## Definition:

a creational pattern to separate the construction of a complex object from its representation so that 
the same construction process can create different representations.

## Applicability

- The Builder pattern assembles a number of objects in various ways depending on the data.
- Use the Builder pattern when
- the algorithm for creating a complex object should be independent on the parts that make up the object and how they're assembled.
- the construction process must allow different representations for the object that's constructed.

## Check list

- Decide if a common input and many possible representations (or outputs) is the problem at hand.
- Encapsulate the parsing of the common input in a Reader class.
- Design a standard protocol for creating all possible output representations. Capture the steps of this protocol in a Builder interface.
- Define a Builder derived class for each target representation.
- The client creates a Reader object and a Builder object, and registers the latter with the former.
- The client asks the Reader to “construct”.
- The client asks the Builder to return the result.


## Consequences

- Abstracts the construction implementation details of a class type. It lets you vary the internal representation of the product that it builds.
- Encapsulates the way in which objects are constructed improving the modularity of a system.
- Finer control over the creation process, by letting a builder class have multiple methods that are called in a sequence to create an object.
- Each specific Builder is independent of any others.


## Rules of thumb

- Sometimes creational patterns are complementory: Builder can use one of the other patterns to implement which components get built. Abstract Factory, Builder, and Prototype can use Singleton in their implementations.
- Builder focuses on constructing a complex object step by step. Abstract Factory emphasizes a family of product objects (either simple or complex). Builder returns the product as a final step, but as far as the Abstract Factory is concerned, the product gets returned immediately.
- Builder often builds a Composite.
- Often, designs start out using Factory Method (less complicated, more customizable, subclasses proliferate) and evolve toward Abstract Factory, Prototype, or Builder (more flexible, more complex) as the designer discovers where more flexibility is needed.




