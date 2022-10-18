# Pattern Based Design Samples

Each of us has encountered a design
problem and silently thought: I wonder if
anyone has developed a solution to for this?

- What if there was a standard way of describing a
problem (so you could look it up), and an
organized method for representing the solution
to the problem?

- Design patterns are a codified method for
describing problems and their solution
allows the software engineering community
to capture design knowledge in a way that
enables it to be reused.

- Each pattern describes a problem that
occurs over and over again in our
environment and then describes the core
of the solution to that problem in such a
way that you can use the solution a
million times over without ever doing it
the same way twice. <br>
  -- Christopher Alexander, 1977
- “a three-part rule which expresses a
relation between `a certain context, a
problem, and a solution`.”

## Basic Concepts

- `Context` allows the reader to understand
the environment in which the problem
resides and what solution might be
appropriate within that environment.
- A set of requirements, including
limitations and constraints, acts as a
`system of forces` that influences how
  - the problem can be interpreted within its
  context and
  - how the solution can be effectively applied.

## Effective Patterns

Coplien [Cop05] characterizes an effective design pattern in the following way:

- `It solves a problem`: Patterns capture solutions, not just abstract principles or strategies.
- `It is a proven concept`: Patterns capture solutions with a track record, not theories or speculation.
- `The solution isn't obvious`: Many problem-solving techniques (such as software design paradigms or methods) try to derive solutions from first principles. The best patterns generate a solution to a problem indirectly--a necessary approach for the most difficult problems of design.
- `It describes a relationship`: Patterns don't just describe modules, but describe deeper system structures and mechanisms.
- `The pattern has a significant human component (minimize human intervention).` All software serves human comfort or quality of life; the best patterns explicitly appeal to aesthetics and utility.

## Kinds of Patterns

- `Architectural patterns` describe broad-based design problems that are solved using a structural approach.
- `Data patterns` describe recurring data-oriented problems and the data modeling solutions that can be used to solve them.
- `Component patterns` (also referred to as `design patterns`) address problems associated with the development of subsystems and components, the manner in which they communicate with one another, and their placement within a larger architecture
- `Interface design patterns` describe common user interface problems and their solution with a system of forces that includes the specific characteristics of end-users.
- `WebApp patterns` address a problem set that is encountered when building WebApps and often incorporates many of the other patterns categories just mentioned.
- `Creational patterns` focus on the “creation, composition, and representation of objects, e.g.,
- `Abstract factory pattern`: centralize decision of what factory to instantiate n Factory method pattern: centralize creation of an object of a specific type
choosing one of several implementations
- `Structural patterns` focus on problems and solutions associated with how classes and objects are organized and integrated to build a larger structure, e.g.,
  - `Adapter pattern`: 'adapts' one interface for a class into one that a client expects 
  - `Aggregate pattern`: a version of the Composite pattern with methods for
  aggregation of children
- `Behavioral patterns`: address problems associated with the assignment of responsibility between objects and the manner in which communication is effected between objects, e.g.,
  - `Chain of responsibility pattern`: Command objects are handled or passed on to other objects by logic-containing processing objects
  - `Command pattern`: Command objects encapsulate an action and its parameters


