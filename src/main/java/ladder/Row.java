package ladder;

public class Row {
    Node[] nodes;


    public Row(NaturalNumber numberOfPerson) {
        nodes = new Node[numberOfPerson.getNumber()];
        for (int i = 0; i < numberOfPerson.getNumber(); i++) {
            nodes[i] = Node.createCenterNode();
        }
    }

    public void drawLine(Position startPosition) {
        validateDrawLinePosition(startPosition);

        nodes[startPosition.getPosition()] = Node.createRightNode();
        nodes[startPosition.getPosition() + 1] = Node.createLeftNode();
    }

    public void nextPosition(Position position) {
        validatePositionSize(position);
        nodes[position.getPosition()].move(position);
    }

    private void validatePositionSize(Position position) {
        if (!position.isSmaller(nodes.length)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDrawLinePosition(Position startPosition) {
        validatePositionSize(startPosition);
        if (nodes[startPosition.getPosition()].isLeft() ||
                nodes[startPosition.getPosition() + 1].isRight()) {
            throw new IllegalArgumentException();
        }
    }

    public StringBuilder printRow(int positionCol, Boolean currentRow){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i].toString());
            if(positionCol == i && currentRow) sb.append("*");
            sb.append(" ");
        }
        sb.append("\n");
        return sb;
    }
    //String 자체를 내보낼지 아니면 그냥 프린트를 할지  - sb 반환 고려

}
