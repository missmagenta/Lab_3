package abstractThings;

import interfaces.Conversationable;

import java.util.Objects;

public class Dialog {
    private Conversationable speaker1;
    private Conversationable speaker2;

    public void addParticipant(Conversationable speaker) {
        if (speaker1 == null) {
            speaker1 = speaker;
        } else if (speaker2 == null) {
            speaker2 = speaker;
        } else {
            System.out.println("This dialog already has 2 participants");
            return;
        }
        speaker.setConversation(this);
        System.out.println(speaker.getName() + " entered the conversation");
    }

    public void say(Conversationable speaker, String message) {
        if (speaker.equals(speaker1) || speaker.equals(speaker2)) {
            System.out.println(speaker.getName() + ": " + message);
        } else {
            System.out.println("Not a participant of this conversation");
        }
    }

    public void removeParticipant(Conversationable speaker) {
        if (speaker1 != null && speaker1.equals(speaker)) {
            speaker1 = null;
        } else if (speaker2 != null && speaker2.equals(speaker)) {
            speaker2 = null;
        } else {
            System.out.println(speaker.getName() + " was not a participant of this dialog");
            return;
        }
        speaker.setConversation(null);
        System.out.println(speaker.getName() + " left the conversation");
    }

    public void setTopic(Conversationable speaker, String topic) {
        System.out.println(speaker.getName() + " set the topic - " + topic);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Dialog that = (Dialog) obj;
        return Objects.equals(speaker1, that.speaker1) &&
                Objects.equals(speaker2, that.speaker2);
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "speaker1='" + speaker1 + '\'' +
                ", speaker2='" + speaker2 + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(speaker1, speaker2);
    }
}
