## Perspectiva

- a distorção da percepção de acordo com a profundida (ou distância) de um objeto. 

## Vetorial 3D

- Ao passarmos para as imagens vetoriais em 3D o primeiro aspecto a ser tratado (além o acrescimo do eixo z) 
é o tipo de projeção: Perspectiva ou Ortogonal.

- A perspectiva é um fenônemeno monocular (não precisa das imagens dos dois olhos) que faz com que percebamos   
uma redução no tamanho dos objetos na medida em que se afastam.

- Portanto, ao renderizar as imagens vetoriais 3D em perspectiva a máquina precisa conhecer o quanto deverá 
reduzir os tamanhos na medida em que os objetos se afastam da câmera.

A projeção ortogonal desconsidera este redimensionamento e trabalha apenas com os máximos e mínimos nos 3 eixos.
