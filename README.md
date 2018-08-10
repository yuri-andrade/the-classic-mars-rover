# Reflexão Inicial sobre o Uso do Git/Github

**Objetivo:** fazer uma reflexão inicial sobre o uso de gerenciamento da configuração, usando o git/github como exemplo
**Enunciado:** Vamos implementar um pequeno programa em equipe e colocá-lo sob gerenciamento da configuração no git e no Github.
Assim, vamos implementar o Mars Rover, cujo enunciado está colocado no moodle. A equipe deve ser organizar da seguinte forma: 
   * montar a equipe (3 integrantes);
   * projetar (em alto nível: idealizar as classes, papel da cada uma) a solução do problema;
   * configurar o git/github da seguinte forma: 
       * acessar o link abaixo, onde você poderá configurar a sua equipe e criar o seu repositório do projeto;
       * cada membro da equipe vai clonar o repositório remoto do Github na sua máquina local;
       * a partir daí, cada membro da equipe trabalhará na sua branch (defina em equipe o nome de cada branch - não use o nome do desenvolvedor  :wink: );
       * uma vez implementados e testados (testes unitários. Se souber utilizar o JUnit, utilize-o) os seus componentes, deverá fazer merge com o ramo master;
       * se for necessário fazer alterações em algum componente, esta deve acontecer na branch de trabalho daquele componente, e não no master (obrigatoriamente. Atentar para merges/rebases que sejam necessários)

**Datas:** Iniciamos hoje, 10/08, em aula, e deve estar concluído até 16/08, às 23:55.

**Orientações gerais:** 
   * as equipes serão formadas por 3 componentes;
   * Lembre-se de dar push periódicos, para que a equipe (e eu :smirk:) possa acomapanhar o desenvolvimento do trabalho;
   * é natural que surjam dúvidas sobre o uso do git/github, ambiente, interpretação, e assim por diante. Compartilhe suas dúvidas no Slack e vamos trabalhar cooperativamente.
   * Material de apoio sobre Git e Github:
      * [Livro do Git](https://git-scm.com/book/en/v2) - referência completa sobre git (com alguma coisa sobre github);
      * [Tutorial](http://rogerdudler.github.io/git-guide/index.pt_BR.html) sobre Git e Github - um tutorial bem básico e inicial;
      * [Guias do Github](https://guides.github.com/) - várias dicas de como usar o Github. [Este é outro guia](http://rogerdudler.github.io/git-guide/) interessante.

**Enunciado do Mars Rover**

###Mars Rover

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously rectangular, must be navigated by the rovers so that their on board cameras can get a complete view of the surrounding terrain to send back to Earth.
A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points. The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90 degrees left or right respectively, without moving from its current spot.
'M' means move forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).
Input:
The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

**Output:**
The output for each rover should be its final co-ordinates and heading.

**Test Input:**
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Expected Output:
1 3 N
5 1 E
